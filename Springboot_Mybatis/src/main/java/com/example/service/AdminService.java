package com.example.service;

import com.example.entity.Admin;

public interface AdminService {

    Boolean insertAdmin(String username, String password);

    Admin selectAdmin(String username, String password);

}
