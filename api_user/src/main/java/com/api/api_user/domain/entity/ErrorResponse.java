package com.api.api_user.domain.entity;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "error")
public class ErrorResponse 
{
  public ErrorResponse(String message, List<String> details) {
    super();
    this.message = message;
    this.details = details;
  }

  private String message;
  private List<String> details;
}