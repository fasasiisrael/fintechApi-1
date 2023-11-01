package com.vpd.controllers;

import com.vpd.models.TransactionRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Transaction API", description = "Operations related to financial transactions")
@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @ApiOperation(value = "Deposit money into an account")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Deposit successful"),
        @ApiResponse(code = 400, message = "Bad request")
    })
    @PostMapping("/deposit")
    public ResponseEntity<String> deposit(@RequestBody TransactionRequest request) {
        // Implement deposit logic and securely log the transaction event
        return ResponseEntity.ok("Deposit successful");
    }

    @ApiOperation(value = "Withdraw money from an account")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Withdrawal successful"),
        @ApiResponse(code = 400, message = "Bad request")
    })
    @PostMapping("/withdraw")
    public ResponseEntity<String> withdraw(@RequestBody TransactionRequest request) {
        // Implement withdrawal logic and securely log the transaction event
        return ResponseEntity.ok("Withdrawal successful");
    }

    @ApiOperation(value = "Transfer money between accounts")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Transfer successful"),
        @ApiResponse(code = 400, message = "Bad request")
    })
    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@RequestBody TransactionRequest request) {
        // Implement transfer logic and securely log the transaction event
        return ResponseEntity.ok("Transfer successful");
    }

   
}
