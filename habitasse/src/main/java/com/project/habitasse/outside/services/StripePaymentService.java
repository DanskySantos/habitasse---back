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
        Map<String, Object> billingDetails = (Map<String, Object>) eventDataMap.get("billing_details");
        String email = (String) billingDetails.get("email");
        Double amount = (Double) eventDataMap.get("amount");
        String receipt_url = (String) eventDataMap.get("receipt_url");
        String eventId = event.getId();
        String objectId = (String) eventDataMap.get("id");
        String invoiceId = (String) eventDataMap.get("invoice");
        String balanceTransactionId = (String) eventDataMap.get("balance_transaction");
        String userName = (String) billingDetails.get("name");
        LocalDateTime created = convertToDateTime((Double) eventDataMap.get("created"));
        PlansEnum plan = PlansEnum.getByValue(amount);

        userService.activateCOUser(email, plan, receipt_url, eventId, objectId, invoiceId, balanceTransactionId, userName, created);
    }

    public static LocalDateTime convertToDateTime(double timestamp) {
        Instant instant = Instant.ofEpochSecond((long) timestamp);
        return LocalDateTime.ofInstant(instant, ZoneId.of("America/Sao_Paulo"));
    }
}
