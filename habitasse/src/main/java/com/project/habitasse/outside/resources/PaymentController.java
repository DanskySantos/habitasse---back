package com.project.habitasse.outside.resources;

import com.project.habitasse.outside.services.StripePaymentService;
import com.stripe.Stripe;
import com.stripe.exception.SignatureVerificationException;
import com.stripe.model.Event;
import com.stripe.net.Webhook;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/api/outside/stripe")
@RequiredArgsConstructor
public class PaymentController {

    @Value("${stripe.api.key}")
    private String stripeApiKey;

    @Value("${stripe.webhook.secret}")
    private String webhookSecret;

    private final StripePaymentService stripePaymentService;

    @PostMapping("/webhook")
    public ResponseEntity<?> handleWebhook(@RequestBody String payload, @RequestHeader("Stripe-Signature") String sigHeader) {
        Stripe.apiKey = stripeApiKey;

        try {
            Event event = Webhook.constructEvent(payload, sigHeader, webhookSecret);

            if (Objects.equals(event.getType(), "charge.succeeded")) {
                stripePaymentService.succeededPayment(event);
            }
            return ResponseEntity.ok().build();

        } catch (SignatureVerificationException e) {
            // Invalid signature
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        } catch (Exception e) {
            // Handle other exceptions
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
