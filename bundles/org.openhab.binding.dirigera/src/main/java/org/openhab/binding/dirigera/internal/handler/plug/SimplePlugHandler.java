/*
 * Copyright (c) 2010-2025 Contributors to the openHAB project
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.openhab.binding.dirigera.internal.handler.plug;

import static org.openhab.binding.dirigera.internal.Constants.*;

import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.json.JSONObject;
import org.openhab.binding.dirigera.internal.handler.BaseHandler;
import org.openhab.core.thing.Thing;

/**
 * The {@link SimplePlugHandler} basic DeviceHandler for all devices
 *
 * @author Bernd Weymann - Initial contribution
 */
@NonNullByDefault
public class SimplePlugHandler extends BaseHandler {
    public SimplePlugHandler(Thing thing, Map<String, String> mapping) {
        super(thing, mapping);
        super.setChildHandler(this);
        // links of types which can be established towards this device
        linkCandidateTypes = List.of(DEVICE_TYPE_LIGHT_CONTROLLER, DEVICE_TYPE_MOTION_SENSOR);
    }

    @Override
    public void initialize() {
        super.initialize();
        if (super.checkHandler()) {
            // handling of first update, also for PowerPlug and SmartPlug child classes!
            JSONObject values = gateway().api().readDevice(config.id);
            handleUpdate(values);
        }
    }
}
