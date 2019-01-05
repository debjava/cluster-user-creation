package com.emc.vxrail.kohl.command;

import com.emc.vxrail.kohl.config.IClusterConfig;

public interface ICommandExecutor {

	void executeCommand(IClusterConfig config) throws Exception ;

}
