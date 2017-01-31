package integration.server.soap;

import integration.client.RestClient;
import integration.client.entity.fatsecret.Day;
import integration.client.entity.fatsecret.Month;
import integration.client.entity.misfit.MisfitActivitySummary;
import integration.client.entity.misfit.MisfitDevice;
import integration.client.entity.misfit.MisfitUser;
import integration.server.model.Device;
import integration.server.model.User;
import integration.server.response.UserCaloriesResponse;
import integration.server.response.UserDevicesResponse;

import javax.jws.WebService;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.security.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;


@WebService(endpointInterface = "integration.server.soap.EndpointInterface"
        , serviceName = "BusinessLogicService")
public class Endpoint implements EndpointInterface {

    public UserDevicesResponse getUserDevices(String id) {
        UserDevicesResponse response = new UserDevicesResponse();

        User user = new User();
        List<Device> deviceList = new ArrayList<Device>();
        final Response misfitUserResponse = RestClient.get("misfit/user", MediaType.APPLICATION_JSON);
        final Response misfitDeviceResponse = RestClient.get("misfit/device", MediaType.APPLICATION_JSON);
        if (misfitUserResponse.getStatus() == 200) {
            MisfitUser misfitUser = misfitUserResponse.readEntity(MisfitUser.class);
            user.setRealName(misfitUser.name);
            if (misfitDeviceResponse.getStatus() == 200) {
                MisfitDevice misfitDevice = misfitDeviceResponse.readEntity(MisfitDevice.class);
                Device device = new Device();
                device.setDeviceType(misfitDevice.deviceType);
                device.setBatteryLevel(misfitDevice.batteryLevel);
                device.setSerialNumber(misfitDevice.serialNumber);
                device.setFirmwareVersion(misfitDevice.firmwareVersion);
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(misfitDevice.lastSyncTime * 1000);
                device.setLastSyncDate(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
                deviceList.add(device);
            }
            user.setDeviceList(deviceList);
        }
        response.setResponse(user);

        return response;
    }

    public UserCaloriesResponse getUserCalories(String id, String year, String month) {
        UserCaloriesResponse response = new UserCaloriesResponse();

        LocalDate start = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), 1);
        LocalDate end = start.withDayOfMonth(start.lengthOfMonth());


        Map<String, Object> misfitParams = new HashMap<>();
        Map<String, Object> fatsecretParams = new HashMap<>();
        misfitParams.put("start", start.toString());
        misfitParams.put("end", end.toString());
        fatsecretParams.put("date", start.toString());

        final Response misfitActivitySummaryResponse = RestClient.get("misfit/activity/summary", MediaType.APPLICATION_JSON, misfitParams);
        if (misfitActivitySummaryResponse.getStatus() == 200) {
            MisfitActivitySummary misfitActivitySummary = misfitActivitySummaryResponse.readEntity(MisfitActivitySummary.class);
            response.setCaloriesConsumed((int)Math.round(misfitActivitySummary.calories));
        }
        final Response fatsecretMonthResponse = RestClient.get("fatsecret/food-diary/month", MediaType.APPLICATION_XML, fatsecretParams);
        if (fatsecretMonthResponse.getStatus() == 200) {
            Month fatsecretMonth = fatsecretMonthResponse.readEntity(Month.class);
            Double caloriesGained = 0.0;
            List<Day> days = fatsecretMonth.getDay();
            for (Day d : days) {
                caloriesGained += d.getCalories().doubleValue();
            }
            response.setCaloriesGained((int)Math.round(caloriesGained));
        }
        response.setCaloriesBalance(response.getCaloriesGained() - response.getCaloriesConsumed());

        response.setYear(Integer.parseInt(year));
        response.setMonth(start.getMonth().name());

        return response;
    }

}
