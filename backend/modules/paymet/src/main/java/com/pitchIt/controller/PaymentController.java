package com.pitchIt.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
 
    @PostMapping("/create-payment-intent")
    public CreatePaymentRespose createPaymentIntent()
}
