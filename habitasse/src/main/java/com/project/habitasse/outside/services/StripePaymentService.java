package com.project.habitasse.outside.services;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.project.habitasse.outside.enums.PlansEnum;
import com.project.habitasse.security.user.service.UserService;
import com.stripe.exception.SignatureVerificationException;
import com.stripe.model.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StripePaymentService {

    private final UserService userService;

    public void succeededPayment(Event event) throws SignatureVerificationException {
        Gson gson = new Gson();
        TypeToken<Map<String, Object>> typeToken = new TypeToken<>() {};
        Map<String, Object> eventDataMap = gson.fromJson(event.getDataObjectDeserializer().getRawJson(), typeToken.getType());
        Map<String, Object> customerDetails = (Map<String, Object>) eventDataMap.get("customer_details");
        String email = (String) customerDetails.get("email");
        String userName = (String) customerDetails.get("name");
        Double amountTotal = (Double) eventDataMap.get("amount_total");
        Integer clientReference = Integer.parseInt((String) eventDataMap.get("client_reference_id"));
        String eventId = event.getId();
        String objectId = (String) eventDataMap.get("id");
        LocalDateTime created = convertToDateTime((Double) eventDataMap.get("created"));
        PlansEnum plan = PlansEnum.getByReference(clientReference);

        userService.activateCOUser(email, plan, eventId, objectId, userName, clientReference, amountTotal, created);
    }

    public static LocalDateTime convertToDateTime(double timestamp) {
        Instant instant = Instant.ofEpochSecond((long) timestamp);
        return LocalDateTime.ofInstant(instant, ZoneId.of("America/Sao_Paulo"));
    }
}
