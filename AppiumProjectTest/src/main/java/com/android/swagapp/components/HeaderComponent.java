package com.android.swagapp.components;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class HeaderComponent {

  // ini yang di cart
  private By totalByOne = AppiumBy.xpath("//android.widget.TextView[@text=\"1\"]");
  @SuppressWarnings("unused")
  private AndroidDriver driver;

  public HeaderComponent(AndroidDriver driver) {
    this.driver = driver;
  }

  public By getTotalByOne() {
    return totalByOne;
  }
    
}
