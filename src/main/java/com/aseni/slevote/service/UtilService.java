package com.aseni.slevote.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UtilService {

    public Map<String,String> getProvinces(){
        return Map.ofEntries(
                Map.entry("WP","Western Province"),
                Map.entry("SP", "Southern Province"),
                Map.entry("NP","Northern Province"),
                Map.entry("EP","Eastern Province"),
                Map.entry("NWP","North Western Province"),
                Map.entry("UP","Uva Province"),
                Map.entry("NCP","North Central Province"),
                Map.entry("CP","Central Province"),
                Map.entry("SG","Sabaragamuwa Province")
        );
    }

    public Map<String,String> getDistricts(){
        return Map.ofEntries(
                Map.entry("CL","Colombo"),
                Map.entry("GP","Gampaha"),
                Map.entry("KL","Kalutara"),
                Map.entry("KN","Kandy"),
                Map.entry("ML","Matale"),
                Map.entry("NE","Nuwara Eliya"),
                Map.entry("GA","Galle"),
                Map.entry("MT","Matara"),
                Map.entry("HM","Hambantota"),
                Map.entry("JF","Jaffna"),
                Map.entry("KI","Kilinochchi"),
                Map.entry("MN","Mannar"),
                Map.entry("VA","Vavuniya"),
                Map.entry("MU","Mullaitivu"),
                Map.entry("BA","Batticaloa"),
                Map.entry("AM","Ampara"),
                Map.entry("TR","Trincomalee"),
                Map.entry("KU","Kurunegala"),
                Map.entry("PU","Puttalam"),
                Map.entry("AN","Anuradhapura"),
                Map.entry("PO","Polonnaruwa"),
                Map.entry("BD","Badulla"),
                Map.entry("MO","Moneragala"),
                Map.entry("RA","Ratnapura"),
                Map.entry("KE","Kegalle")
        );
    }


}
