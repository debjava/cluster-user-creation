package com.emc.vxrail.kohl.config;

import com.emc.vxrail.kohl.bean.VCenterHost;

public interface IConfigReader {
  IClusterConfig getClusterConfiguration();

  VCenterHost getvCenterHost();
}
