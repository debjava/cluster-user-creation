package com.emc.vxrail.kohl.config;

import com.emc.vxrail.kohl.bean.JumpHost;

public interface IConfigReader {
  IClusterConfig getClusterConfiguration();

  JumpHost getJumpHost();
}
