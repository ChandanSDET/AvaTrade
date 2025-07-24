package com.bhas.complex.payload;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class Hierarchy {
private String Name;
private String ParentName;
}
