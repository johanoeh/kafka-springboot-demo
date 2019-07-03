/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.sundsvall.midalva.kafkademo.model;

import lombok.Data;

/**
 *
 * @author johan
 */
@Data
public class Subscription {
    
    private String id;
    private String userIdentificationNumber;
    private String timeStamp;
 
}
