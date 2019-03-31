package com.mybatis.controller;

import com.mybatis.model.BankAccount;
import com.mybatis.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin("*")
@RequestMapping("/bankaccount")
@RestController
public class BankAccountController {
    @Autowired
    BankAccountService bankAccountService;

    @PostMapping("/create")
    Integer insert(@RequestBody BankAccount bankAccount) {
        LocalDateTime localDateTime = LocalDateTime.now();
        bankAccount.setCreateTs(localDateTime);
        return bankAccountService.insert(bankAccount);
    }

    @GetMapping("/all")
    List<BankAccount> findAll() {
        return bankAccountService.findAll();
    }

    @GetMapping("/findByUserId/{id}")
    List<BankAccount> findByUseId(@PathVariable Integer id) {
        return  bankAccountService.findByUserId(id);
    }
}
