package com.example.demo.controller;
import com.example.demo.model.User;
import com.example.demo.mapper.UserMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping({"/user"})
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @RequestMapping(value = "/user")
    @ResponseBody
    public String getUserInfoByName(String account){
        User user = userMapper.findByAccount(account);
        if (user == null) {
            return "null";
        } else {
            JSONObject json = new JSONObject();
            try {
                JSONArray arr = new JSONArray();
                json.put("name",user.getUserName());
                json.put("password",user.getPassword());
                json.put("id",user.getId());
                json.put("account",user.getAccount());
                arr.put(json);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return json.toString();
        }
    }
}