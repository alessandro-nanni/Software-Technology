package com.amol.microservices.ecommerce.entity;

import lombok.Setter;
import lombok.Getter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Image {

    private Long Id;

    private int productId;

    private String path;

}
