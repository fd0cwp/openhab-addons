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
package org.openhab.binding.shelly.internal.discovery;

import static org.openhab.binding.shelly.internal.ShellyBindingConstants.BINDING_ID;
import static org.openhab.binding.shelly.internal.api1.Shelly1ApiJsonDTO.*;
import static org.openhab.binding.shelly.internal.util.ShellyUtils.*;

import java.util.Map;
import java.util.regex.Pattern;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.openhab.core.thing.ThingTypeUID;
import org.openhab.core.thing.ThingUID;

/**
 * The {@link ShellyThingCreator} maps the device id into the thing type id
 *
 * @author Markus Michels - Initial contribution
 */
@NonNullByDefault
public class ShellyThingCreator {
    private static final Pattern SHELLY_SERVICE_NAME_PATTERN = Pattern
            .compile("^([a-z0-9]*shelly[a-z0-9]*)-([a-z0-9]+)$", Pattern.CASE_INSENSITIVE);

    // Device Types
    public static final String SHELLYDT_1 = "SHSW-1";
    public static final String SHELLYDT_1PM = "SHSW-PM";
    public static final String SHELLYDT_1L = "SHSW-L";
    public static final String SHELLYDT_SHPLG = "SHPLG-1";
    public static final String SHELLYDT_SHPLG_S = "SHPLG-S";
    public static final String SHELLYDT_SHPLG_U1 = "SHPLG-U1";
    public static final String SHELLYDT_SHELLY2 = "SHSW-21";
    public static final String SHELLYDT_SHELLY25 = "SHSW-25";
    public static final String SHELLYDT_SHPRO = "SHSW-44";
    public static final String SHELLYDT_EM = "SHEM";
    public static final String SHELLYDT_3EM = "SHEM-3";
    public static final String SHELLYDT_HT = "SHHT-1";
    public static final String SHELLYDT_DW = "SHDW-1";
    public static final String SHELLYDT_DW2 = "SHDW-2";
    public static final String SHELLYDT_SENSE = "SHSEN-1";
    public static final String SHELLYDT_MOTION = "SHMOS-01";
    public static final String SHELLYDT_MOTION2 = "SHMOS-02";
    public static final String SHELLYDT_GAS = "SHGS-1";
    public static final String SHELLYDT_DIMMER = "SHDM-1";
    public static final String SHELLYDT_DIMMER2 = "SHDM-2";
    public static final String SHELLYDT_IX3 = "SHIX3-1";
    public static final String SHELLYDT_BULB = "SHBLB-1";
    public static final String SHELLYDT_DUO = "SHBDUO-1";
    public static final String SHELLYDT_DUORGBW = "SHCB-1";
    public static final String SHELLYDT_VINTAGE = "SHVIN-1";
    public static final String SHELLYDT_RGBW2 = "SHRGBW2";
    public static final String SHELLYDT_BUTTON1 = "SHBTN-1";
    public static final String SHELLYDT_BUTTON2 = "SHBTN-2";
    public static final String SHELLYDT_UNI = "SHUNI-1";
    public static final String SHELLYDT_TRV = "SHTRV-01";

    // Shelly Plus Series
    public static final String SHELLYDT_PLUS1 = "SNSW-001X16EU";
    public static final String SHELLYDT_PLUS1G3 = "S3SW-001X16EU";
    public static final String SHELLYDT_PLUS1G4 = "S4SW-001X16EU";
    public static final String SHELLYDT_PLUS1PM = "SNSW-001P16EU";
    public static final String SHELLYDT_PLUS1PMG3 = "S3SW-001P16EU";
    public static final String SHELLYDT_PLUS1PMG4 = "S4SW-001P16EU";
    public static final String SHELLYDT_PLUS1UL = "SNSW-001X15UL";
    public static final String SHELLYDT_PLUS1PMUL = "SNSW-001P15UL";
    public static final String SHELLYDT_PLUS2PM = "SNSW-002P16EU";
    public static final String SHELLYDT_PLUS2PM_2 = "SNSW-102P16EU";
    public static final String SHELLYDT_PLUS2PMG3 = "S3SW-002P16EU";
    public static final String SHELLYDT_PLUS2PMUL = "SNSW-002P15UL";
    public static final String SHELLYDT_PLUSPLUGS = "SNPL-00112EU";
    public static final String SHELLYDT_PLUSPLUGS_2 = "SNPL-10112EU";
    public static final String SHELLYDT_PLUSPLUGSG3 = "S3PL-00112EU"; // Shelly Plug-S G3, Shelly AZ Plug
    public static final String SHELLYDT_PLUSPLUGOUTDOORSG3 = "S3PL-20112EU";

    public static final String SHELLYDT_PLUSPLUGIT = "SNPL-00110IT";
    public static final String SHELLYDT_PLUSPLUGUK = "SNPL-00112UK";
    public static final String SHELLYDT_PLUSPLUGUS = "SNPL-00116US";
    public static final String SHELLYDT_PLUSI4 = "SNSN-0024X";
    public static final String SHELLYDT_PLUSI4G3 = "S3SN-0024X";
    public static final String SHELLYDT_PLUSI4DC = "SNSN-0D24X";
    public static final String SHELLYDT_PLUSHT = "SNSN-0013A";
    public static final String SHELLYDT_PLUSHTG3 = "S3SN-0U12A";
    public static final String SHELLYDT_PLUSSMOKE = "SNSN-0031Z";
    public static final String SHELLYDT_PLUSUNI = "SNSN-0043X";
    public static final String SHELLYDT_PLUSDIMMERUS = "SNDM-0013US";
    public static final String SHELLYDT_PLUSDIMMER10V = "SNDM-00100WW";
    public static final String SHELLYDT_PLUSDIMMER0110VG3 = "S3DM-0010WW";
    public static final String SHELLYDT_PLUSWALLDISPLAY = "SAWD-0A1XX10EU1";
    public static final String SHELLYDT_PLUSRGBWPM = "SNDC-0D4P10WW";

    // Shelly Pro Series
    public static final String SHELLYDT_PRO1 = "SPSW-001XE16EU";
    public static final String SHELLYDT_PRO1_2 = "SPSW-101XE16EU";
    public static final String SHELLYDT_PRO1_3 = "SPSW-201XE16EU";
    public static final String SHELLYDT_PRO1PM = "SPSW-001PE16EU";
    public static final String SHELLYDT_PRO1PM_2 = "SPSW-101PE16EU";
    public static final String SHELLYDT_PRO1PM_3 = "SPSW-201PE16EU";
    public static final String SHELLYDT_PRO1CB = "SPCB-01VENEU";
    public static final String SHELLYDT_PRO2 = "SPSW-002XE16EU";
    public static final String SHELLYDT_PRO2_2 = "SPSW-102XE16EU";
    public static final String SHELLYDT_PRO2_3 = "SPSW-202XE16EU";
    public static final String SHELLYDT_PRO2PM = "SPSW-002PE16EU";
    public static final String SHELLYDT_PRO2PM_2 = "SPSW-102PE16EU";
    public static final String SHELLYDT_PRO2PM_3 = "SPSW-202PE16EU";
    public static final String SHELLYDT_PRO3 = "SPSW-003XE16EU";
    public static final String SHELLYDT_PRO3EM = "SPEM-003CEBEU";
    public static final String SHELLYDT_PROEM50 = "SPEM-002CEBEU50";
    public static final String SHELLYDT_PRO4PM = "SPSW-004PE16EU";
    public static final String SHELLYDT_PRO4PM_2 = "SPSW-104PE16EU";
    public static final String SHELLYDT_4PRO = "SHPSW04P";

    // Shelly Plus Mini Series
    // Mini Generation 2
    public static final String SHELLYDT_MINI1 = "SNSW-001X8EU";
    public static final String SHELLYDT_MINIPM = "SNPM-001PCEU16";
    public static final String SHELLYDT_MINI1PM = "SNSW-001P8EU";
    // Mini Generation 3
    public static final String SHELLYDT_MINIG3_1 = "S3SW-001X8EU";
    public static final String SHELLYDT_MINIG3_PM = "S3PM-001PCEU16";
    public static final String SHELLYDT_MINIG3_1PM = "S3SW-001P8EU";
    // Mini Generation 4
    public static final String SHELLYDT_MINIG4_1 = "S4SW-001X8EU";
    public static final String SHELLYDT_MINIG4_PM = "S4EM-001PXCEU16";
    public static final String SHELLYDT_MINIG4_1PM = "S4SW-001P8EU";

    // Shelly BLU Series
    public static final String SHELLYDT_BLUBUTTON = "SBBT";
    public static final String SHELLYDT_BLUDW = "SBDW";
    public static final String SHELLYDT_BLUMOTION = "SBMO";
    public static final String SHELLYDT_BLUHT = "SBHT";
    public static final String SHELLYDT_BLUGW = "SNGW-BT01";
    public static final String SHELLYDT_BLUGWG3 = "S3GW-1DBT001";

    // Thing names
    public static final String THING_TYPE_SHELLY1_STR = "shelly1";
    public static final String THING_TYPE_SHELLY1L_STR = "shelly1l";
    public static final String THING_TYPE_SHELLY1PM_STR = "shelly1pm";
    public static final String THING_TYPE_SHELLYEM_STR = "shellyem";
    public static final String THING_TYPE_SHELLY3EM_STR = "shellyem3"; // bad: misspelled product name, it's 3EM
    public static final String THING_TYPE_SHELLY2_PREFIX = "shellyswitch";
    public static final String THING_TYPE_SHELLY2_RELAY_STR = "shelly2-relay";
    public static final String THING_TYPE_SHELLY2_ROLLER_STR = "shelly2-roller";
    public static final String THING_TYPE_SHELLY25_PREFIX = "shellyswitch25";
    public static final String THING_TYPE_SHELLY25_RELAY_STR = "shelly25-relay";
    public static final String THING_TYPE_SHELLY25_ROLLER_STR = "shelly25-roller";
    public static final String THING_TYPE_SHELLY4PRO_STR = "shelly4pro";
    public static final String THING_TYPE_SHELLYPLUG_STR = "shellyplug";
    public static final String THING_TYPE_SHELLYPLUGS_STR = "shellyplugs";
    public static final String THING_TYPE_SHELLYPLUGU1_STR = "shellyplugu1"; // Shelly Plug US
    public static final String THING_TYPE_SHELLYDIMMER_STR = "shellydimmer";
    public static final String THING_TYPE_SHELLYDIMMER2_STR = "shellydimmer2";
    public static final String THING_TYPE_SHELLYIX3_STR = "shellyix3";
    public static final String THING_TYPE_SHELLYBULB_STR = "shellybulb";
    public static final String THING_TYPE_SHELLYDUO_STR = "shellybulbduo";
    public static final String THING_TYPE_SHELLYVINTAGE_STR = "shellyvintage";
    public static final String THING_TYPE_SHELLYRGBW2_PREFIX = "shellyrgbw2";
    public static final String THING_TYPE_SHELLYRGBW2_COLOR_STR = THING_TYPE_SHELLYRGBW2_PREFIX + "-color";
    public static final String THING_TYPE_SHELLYRGBW2_WHITE_STR = THING_TYPE_SHELLYRGBW2_PREFIX + "-white";
    public static final String THING_TYPE_SHELLYDUORGBW_STR = "shellycolorbulb";
    public static final String THING_TYPE_SHELLYHT_STR = "shellyht";
    public static final String THING_TYPE_SHELLYSMOKE_STR = "shellysmoke";
    public static final String THING_TYPE_SHELLYGAS_STR = "shellygas";
    public static final String THING_TYPE_SHELLYFLOOD_STR = "shellyflood";
    public static final String THING_TYPE_SHELLYDOORWIN_STR = "shellydw";
    public static final String THING_TYPE_SHELLYDOORWIN2_STR = "shellydw2";
    public static final String THING_TYPE_SHELLYEYE_STR = "shellyseye";
    public static final String THING_TYPE_SHELLYSENSE_STR = "shellysense";
    public static final String THING_TYPE_SHELLYTRV_STR = "shellytrv";
    public static final String THING_TYPE_SHELLYMOTION_STR = "shellymotion";
    public static final String THING_TYPE_SHELLYMOTION2_STR = "shellymotion2";
    public static final String THING_TYPE_SHELLYBUTTON1_STR = "shellybutton1";
    public static final String THING_TYPE_SHELLYBUTTON2_STR = "shellybutton2";
    public static final String THING_TYPE_SHELLYUNI_STR = "shellyuni";

    // Shelly Plus Series
    public static final String THING_TYPE_SHELLYPLUS1_STR = "shellyplus1";
    public static final String THING_TYPE_SHELLYPLUS1G3_STR = "shelly1g3";
    public static final String THING_TYPE_SHELLYPLUS1G4_STR = "shelly1g4";
    public static final String THING_TYPE_SHELLYPLUS1PM_STR = "shellyplus1pm";
    public static final String THING_TYPE_SHELLYPLUS1PMG3_STR = "shelly1pmg3";
    public static final String THING_TYPE_SHELLYPLUS1PMG4_STR = "shelly1pmg4";
    public static final String THING_TYPE_SHELLYPLUS2PM_RELAY_STR = "shellyplus2pm-relay";
    public static final String THING_TYPE_SHELLYPLUS2PM_ROLLER_STR = "shellyplus2pm-roller";
    public static final String THING_TYPE_SHELLYPLUSI4_STR = "shellyplusi4";
    public static final String THING_TYPE_SHELLYPLUSI4G3_STR = "shellyi4g3";
    public static final String THING_TYPE_SHELLYPLUSI4DC_STR = "shellyplusi4dc";
    public static final String THING_TYPE_SHELLYPLUSHT_STR = "shellyplusht";
    public static final String THING_TYPE_SHELLYPLUSHTG3_STR = "shellyhtg3";
    public static final String THING_TYPE_SHELLYPLUSSMOKE_STR = "shellyplussmoke";
    public static final String THING_TYPE_SHELLYPLUSUNI_STR = "shellyplusuni";
    public static final String THING_TYPE_SHELLYPLUSPLUGS_STR = "shellyplusplug";
    public static final String SVC_TYPE_SHELLYPLUSPLUGUS_STR = "shellyplugus";
    public static final String THING_TYPE_SHELLYPLUSPLUGUS_STR = "shellyplusplugus";
    public static final String THING_TYPE_SHELLYPLUSDIMMERUS_STR = "shellypluswdus";
    public static final String THING_TYPE_SHELLYPLUSDIMMER10V_STR = "shellyplus10v";
    public static final String THING_TYPE_SHELLYPLUSDIMMER0110VG3_STR = "shelly0110dimg3";
    public static final String THING_TYPE_SHELLYPLUSRGBWPM_STR = "shellyplusrgbwpm";

    // Shelly Wall Display
    public static final String THING_TYPE_SHELLYPLUSWALLDISPLAY_STR = "shellywalldisplay";

    // Shelly Plus Mini Series
    public static final String THING_TYPE_SHELLY1MINI_STR = "shelly1mini";
    public static final String THING_TYPE_SHELLYMINI1G3_STR = "shelly1minig3";
    public static final String THING_TYPE_SHELLYMINI1G4_STR = "shelly1minig4";
    public static final String THING_TYPE_SHELLYPMMINI_STR = "shellypmmini";
    public static final String THING_TYPE_SHELLYPMMINIG3_STR = "shellypmminig3";
    public static final String THING_TYPE_SHELLYPMMINIG4_STR = "shellypmminig4";
    public static final String THING_TYPE_SHELLY1PMMINI_STR = "shelly1pmmini";
    public static final String THING_TYPE_SHELLY1PMMINIG3_STR = "shelly1pmminig3";
    public static final String THING_TYPE_SHELLY1PMMINIG4_STR = "shelly1pmminig4";
    // Shelly Pro Series
    public static final String THING_TYPE_SHELLYPRO1_STR = "shellypro1";
    public static final String THING_TYPE_SHELLYPRO1PM_STR = "shellypro1pm";
    public static final String THING_TYPE_SHELLYPRO1CB_STR = "shellypro1cb";
    public static final String THING_TYPE_SHELLYPRO2_RELAY_STR = "shellypro2-relay";
    public static final String THING_TYPE_SHELLYPRO2PM_RELAY_STR = "shellypro2pm-relay";
    public static final String THING_TYPE_SHELLYPRO2PM_ROLLER_STR = "shellypro2pm-roller";
    public static final String THING_TYPE_SHELLYPRO3_STR = "shellypro3";
    public static final String THING_TYPE_SHELLYPRO3EM_STR = "shellypro3em";
    public static final String THING_TYPE_SHELLYPROEM50_STR = "shellyproem50";
    public static final String THING_TYPE_SHELLYPRO4PM_STR = "shellypro4pm";

    // Shelly BLU Series
    public static final String THING_TYPE_SHELLYBLU_PREFIX = "shellyblu";
    public static final String THING_TYPE_SHELLYBLUBUTTON_STR = THING_TYPE_SHELLYBLU_PREFIX + "button";
    public static final String THING_TYPE_SHELLYBLUDW_STR = THING_TYPE_SHELLYBLU_PREFIX + "dw";
    public static final String THING_TYPE_SHELLYBLUMOTION_STR = THING_TYPE_SHELLYBLU_PREFIX + "motion";
    public static final String THING_TYPE_SHELLYBLUHT_STR = THING_TYPE_SHELLYBLU_PREFIX + "ht";
    public static final String THING_TYPE_SHELLYBLUGW_STR = THING_TYPE_SHELLYBLU_PREFIX + "gw";
    public static final String THING_TYPE_SHELLYBLUGWG3_STR = THING_TYPE_SHELLYBLU_PREFIX + "gwg3";

    // Password protected or unknown device
    public static final String THING_TYPE_SHELLYPROTECTED_STR = "shellydevice";
    public static final String THING_TYPE_SHELLYUNKNOWN_STR = "shellyunknown";

    // List of all Thing Type UIDs
    public static final ThingTypeUID THING_TYPE_SHELLY1 = new ThingTypeUID(BINDING_ID, THING_TYPE_SHELLY1_STR);
    public static final ThingTypeUID THING_TYPE_SHELLY1L = new ThingTypeUID(BINDING_ID, THING_TYPE_SHELLY1L_STR);
    public static final ThingTypeUID THING_TYPE_SHELLY1PM = new ThingTypeUID(BINDING_ID, THING_TYPE_SHELLY1PM_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYEM = new ThingTypeUID(BINDING_ID, THING_TYPE_SHELLYEM_STR);
    public static final ThingTypeUID THING_TYPE_SHELLY3EM = new ThingTypeUID(BINDING_ID, THING_TYPE_SHELLY3EM_STR);
    public static final ThingTypeUID THING_TYPE_SHELLY2_RELAY = new ThingTypeUID(BINDING_ID,
            THING_TYPE_SHELLY2_RELAY_STR);
    public static final ThingTypeUID THING_TYPE_SHELLY2_ROLLER = new ThingTypeUID(BINDING_ID,
            THING_TYPE_SHELLY2_ROLLER_STR);
    public static final ThingTypeUID THING_TYPE_SHELLY25_RELAY = new ThingTypeUID(BINDING_ID,
            THING_TYPE_SHELLY25_RELAY_STR);
    public static final ThingTypeUID THING_TYPE_SHELLY25_ROLLER = new ThingTypeUID(BINDING_ID,
            THING_TYPE_SHELLY25_ROLLER_STR);
    public static final ThingTypeUID THING_TYPE_SHELLY4PRO = new ThingTypeUID(BINDING_ID, THING_TYPE_SHELLY4PRO_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYPLUG = new ThingTypeUID(BINDING_ID, THING_TYPE_SHELLYPLUG_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYPLUGS = new ThingTypeUID(BINDING_ID, THING_TYPE_SHELLYPLUGS_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYPLUGU1 = new ThingTypeUID(BINDING_ID,
            THING_TYPE_SHELLYPLUGU1_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYUNI = new ThingTypeUID(BINDING_ID, THING_TYPE_SHELLYUNI_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYDIMMER = new ThingTypeUID(BINDING_ID,
            THING_TYPE_SHELLYDIMMER_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYDIMMER2 = new ThingTypeUID(BINDING_ID,
            THING_TYPE_SHELLYDIMMER2_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYIX3 = new ThingTypeUID(BINDING_ID, THING_TYPE_SHELLYIX3_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYBULB = new ThingTypeUID(BINDING_ID, THING_TYPE_SHELLYBULB_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYDUO = new ThingTypeUID(BINDING_ID, THING_TYPE_SHELLYDUO_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYVINTAGE = new ThingTypeUID(BINDING_ID,
            THING_TYPE_SHELLYVINTAGE_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYDUORGBW = new ThingTypeUID(BINDING_ID,
            THING_TYPE_SHELLYDUORGBW_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYHT = new ThingTypeUID(BINDING_ID, THING_TYPE_SHELLYHT_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYSENSE = new ThingTypeUID(BINDING_ID, THING_TYPE_SHELLYSENSE_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYSMOKE = new ThingTypeUID(BINDING_ID, THING_TYPE_SHELLYSMOKE_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYGAS = new ThingTypeUID(BINDING_ID, THING_TYPE_SHELLYGAS_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYFLOOD = new ThingTypeUID(BINDING_ID, THING_TYPE_SHELLYFLOOD_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYDOORWIN = new ThingTypeUID(BINDING_ID,
            THING_TYPE_SHELLYDOORWIN_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYDOORWIN2 = new ThingTypeUID(BINDING_ID,
            THING_TYPE_SHELLYDOORWIN2_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYTRV = new ThingTypeUID(BINDING_ID, THING_TYPE_SHELLYTRV_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYBUTTON1 = new ThingTypeUID(BINDING_ID,
            THING_TYPE_SHELLYBUTTON1_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYBUTTON2 = new ThingTypeUID(BINDING_ID,
            THING_TYPE_SHELLYBUTTON2_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYEYE = new ThingTypeUID(BINDING_ID, THING_TYPE_SHELLYEYE_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYMOTION = new ThingTypeUID(BINDING_ID,
            THING_TYPE_SHELLYMOTION_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYRGBW2_COLOR = new ThingTypeUID(BINDING_ID,
            THING_TYPE_SHELLYRGBW2_COLOR_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYRGBW2_WHITE = new ThingTypeUID(BINDING_ID,
            THING_TYPE_SHELLYRGBW2_WHITE_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYPROTECTED = new ThingTypeUID(BINDING_ID,
            THING_TYPE_SHELLYPROTECTED_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYUNKNOWN = new ThingTypeUID(BINDING_ID,
            THING_TYPE_SHELLYUNKNOWN_STR);

    // Shelly Plus
    public static final ThingTypeUID THING_TYPE_SHELLYPLUS1 = new ThingTypeUID(BINDING_ID, THING_TYPE_SHELLYPLUS1_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYPLUS1PM = new ThingTypeUID(BINDING_ID,
            THING_TYPE_SHELLYPLUS1PM_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYPLUS2PM_RELAY = new ThingTypeUID(BINDING_ID,
            THING_TYPE_SHELLYPLUS2PM_RELAY_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYPLUS2PM_ROLLER = new ThingTypeUID(BINDING_ID,
            THING_TYPE_SHELLYPLUS2PM_ROLLER_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYPLUSI4 = new ThingTypeUID(BINDING_ID,
            THING_TYPE_SHELLYPLUSI4_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYPLUSI4DC = new ThingTypeUID(BINDING_ID,
            THING_TYPE_SHELLYPLUSI4DC_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYPLUSHT = new ThingTypeUID(BINDING_ID,
            THING_TYPE_SHELLYPLUSHT_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYPLUSUNI = new ThingTypeUID(BINDING_ID,
            THING_TYPE_SHELLYPLUSUNI_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYPLUSHTG3 = new ThingTypeUID(BINDING_ID,
            THING_TYPE_SHELLYPLUSHTG3_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYPLUSSMOKE = new ThingTypeUID(BINDING_ID,
            THING_TYPE_SHELLYPLUSSMOKE_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYPLUSPLUGS = new ThingTypeUID(BINDING_ID,
            THING_TYPE_SHELLYPLUSPLUGS_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYPLUSPLUGUS = new ThingTypeUID(BINDING_ID,
            THING_TYPE_SHELLYPLUSPLUGUS_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYPLUSDIMMERUS = new ThingTypeUID(BINDING_ID,
            THING_TYPE_SHELLYPLUSDIMMERUS_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYPLUSDIMMER10V = new ThingTypeUID(BINDING_ID,
            THING_TYPE_SHELLYPLUSDIMMER10V_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYPLUSRGBWPM = new ThingTypeUID(BINDING_ID,
            THING_TYPE_SHELLYPLUSRGBWPM_STR);

    // Shelly Wall Display
    public static final ThingTypeUID THING_TYPE_SHELLYPLUSWALLDISPLAY = new ThingTypeUID(BINDING_ID,
            THING_TYPE_SHELLYPLUSWALLDISPLAY_STR);

    // Shelly Plus Mini Series
    public static final ThingTypeUID THING_TYPE_SHELLY1MINI = new ThingTypeUID(BINDING_ID, THING_TYPE_SHELLY1MINI_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYPMMINI = new ThingTypeUID(BINDING_ID,
            THING_TYPE_SHELLYPMMINI_STR);
    public static final ThingTypeUID THING_TYPE_SHELLY1PMMINI = new ThingTypeUID(BINDING_ID,
            THING_TYPE_SHELLY1PMMINI_STR);

    // Shelly Pro
    public static final ThingTypeUID THING_TYPE_SHELLYPRO1 = new ThingTypeUID(BINDING_ID, THING_TYPE_SHELLYPRO1_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYPRO1PM = new ThingTypeUID(BINDING_ID,
            THING_TYPE_SHELLYPRO1PM_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYPRO1CB = new ThingTypeUID(BINDING_ID,
            THING_TYPE_SHELLYPRO1CB_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYPRO2_RELAY = new ThingTypeUID(BINDING_ID,
            THING_TYPE_SHELLYPRO2_RELAY_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYPRO2PM_RELAY = new ThingTypeUID(BINDING_ID,
            THING_TYPE_SHELLYPRO2PM_RELAY_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYPRO2PM_ROLLER = new ThingTypeUID(BINDING_ID,
            THING_TYPE_SHELLYPRO2PM_ROLLER_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYPRO3 = new ThingTypeUID(BINDING_ID, THING_TYPE_SHELLYPRO3_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYPRO3EM = new ThingTypeUID(BINDING_ID,
            THING_TYPE_SHELLYPRO3EM_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYPROEM50 = new ThingTypeUID(BINDING_ID,
            THING_TYPE_SHELLYPROEM50_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYPRO4PM = new ThingTypeUID(BINDING_ID,
            THING_TYPE_SHELLYPRO4PM_STR);

    // Shelly Blu series
    public static final ThingTypeUID THING_TYPE_SHELLYBLUBUTTON = new ThingTypeUID(BINDING_ID,
            THING_TYPE_SHELLYBLUBUTTON_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYBLUDW = new ThingTypeUID(BINDING_ID, THING_TYPE_SHELLYBLUDW_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYBLUMOTION = new ThingTypeUID(BINDING_ID,
            THING_TYPE_SHELLYBLUMOTION_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYBLUHT = new ThingTypeUID(BINDING_ID, THING_TYPE_SHELLYBLUHT_STR);
    public static final ThingTypeUID THING_TYPE_SHELLYBLUGW = new ThingTypeUID(BINDING_ID, THING_TYPE_SHELLYBLUGW_STR);

    private static final Map<String, ThingTypeUID> THING_TYPE_BY_DEVICE_TYPE = Map.ofEntries(
            Map.entry(SHELLYDT_1PM, THING_TYPE_SHELLY1PM), //
            Map.entry(SHELLYDT_1L, THING_TYPE_SHELLY1L), //
            Map.entry(SHELLYDT_1, THING_TYPE_SHELLY1), //
            Map.entry(SHELLYDT_SHPRO, THING_TYPE_SHELLY4PRO), //
            Map.entry(SHELLYDT_3EM, THING_TYPE_SHELLY3EM), //
            Map.entry(SHELLYDT_EM, THING_TYPE_SHELLYEM), //
            Map.entry(SHELLYDT_SHPLG_S, THING_TYPE_SHELLYPLUGS), //
            Map.entry(SHELLYDT_SHPLG_U1, THING_TYPE_SHELLYPLUGU1), //
            Map.entry(SHELLYDT_GAS, THING_TYPE_SHELLYGAS), //
            Map.entry(SHELLYDT_DW, THING_TYPE_SHELLYDOORWIN), //
            Map.entry(SHELLYDT_DW2, THING_TYPE_SHELLYDOORWIN2), //
            Map.entry(SHELLYDT_DUO, THING_TYPE_SHELLYDUO), //
            Map.entry(SHELLYDT_DUORGBW, THING_TYPE_SHELLYDUORGBW), //
            Map.entry(SHELLYDT_BULB, THING_TYPE_SHELLYBULB), //
            Map.entry(SHELLYDT_VINTAGE, THING_TYPE_SHELLYVINTAGE), //
            Map.entry(SHELLYDT_DIMMER, THING_TYPE_SHELLYDIMMER), //
            Map.entry(SHELLYDT_DIMMER2, THING_TYPE_SHELLYDIMMER2), //
            Map.entry(SHELLYDT_IX3, THING_TYPE_SHELLYIX3), //
            Map.entry(SHELLYDT_BUTTON1, THING_TYPE_SHELLYBUTTON1),
            Map.entry(SHELLYDT_BUTTON2, THING_TYPE_SHELLYBUTTON2), //
            Map.entry(SHELLYDT_UNI, THING_TYPE_SHELLYUNI), //
            Map.entry(SHELLYDT_HT, THING_TYPE_SHELLYHT), //
            Map.entry(SHELLYDT_TRV, THING_TYPE_SHELLYTRV), //
            Map.entry(SHELLYDT_MOTION, THING_TYPE_SHELLYMOTION),

            // Plus Series
            Map.entry(SHELLYDT_PLUS1, THING_TYPE_SHELLYPLUS1), //
            Map.entry(SHELLYDT_PLUS1G3, THING_TYPE_SHELLYPLUS1), //
            Map.entry(SHELLYDT_PLUS1G4, THING_TYPE_SHELLYPLUS1), //
            Map.entry(SHELLYDT_PLUS1UL, THING_TYPE_SHELLYPLUS1), //
            Map.entry(SHELLYDT_PLUS1PM, THING_TYPE_SHELLYPLUS1PM),
            Map.entry(SHELLYDT_PLUS1PMG3, THING_TYPE_SHELLYPLUS1PM),
            Map.entry(SHELLYDT_PLUS1PMG4, THING_TYPE_SHELLYPLUS1PM),
            Map.entry(SHELLYDT_PLUS1PMUL, THING_TYPE_SHELLYPLUS1PM),
            Map.entry(SHELLYDT_PLUSPLUGS, THING_TYPE_SHELLYPLUSPLUGS),
            Map.entry(SHELLYDT_PLUSPLUGS_2, THING_TYPE_SHELLYPLUSPLUGS),
            Map.entry(SHELLYDT_PLUSPLUGSG3, THING_TYPE_SHELLYPLUSPLUGS),
            Map.entry(SHELLYDT_PLUSPLUGIT, THING_TYPE_SHELLYPLUSPLUGS),
            Map.entry(SHELLYDT_PLUSPLUGOUTDOORSG3, THING_TYPE_SHELLYPLUSPLUGS),
            Map.entry(SHELLYDT_PLUSPLUGUK, THING_TYPE_SHELLYPLUSPLUGS),
            Map.entry(SHELLYDT_PLUSPLUGUS, THING_TYPE_SHELLYPLUSPLUGUS),
            Map.entry(SHELLYDT_PLUSI4, THING_TYPE_SHELLYPLUSI4), //
            Map.entry(SHELLYDT_PLUSI4G3, THING_TYPE_SHELLYPLUSI4),
            Map.entry(SHELLYDT_PLUSI4DC, THING_TYPE_SHELLYPLUSI4DC),
            Map.entry(SHELLYDT_PLUSHT, THING_TYPE_SHELLYPLUSHT),
            Map.entry(SHELLYDT_PLUSHTG3, THING_TYPE_SHELLYPLUSHTG3),
            Map.entry(SHELLYDT_PLUSSMOKE, THING_TYPE_SHELLYPLUSSMOKE),
            Map.entry(SHELLYDT_PLUSUNI, THING_TYPE_SHELLYPLUSUNI),
            Map.entry(SHELLYDT_PLUSDIMMERUS, THING_TYPE_SHELLYPLUSDIMMERUS),
            Map.entry(SHELLYDT_PLUSDIMMER10V, THING_TYPE_SHELLYPLUSDIMMER10V),
            Map.entry(SHELLYDT_PLUSDIMMER0110VG3, THING_TYPE_SHELLYPLUSDIMMER10V),
            Map.entry(SHELLYDT_PLUSRGBWPM, THING_TYPE_SHELLYPLUSRGBWPM),

            // Plus Mini Series
            Map.entry(SHELLYDT_MINI1, THING_TYPE_SHELLY1MINI), //
            Map.entry(SHELLYDT_MINIG3_1, THING_TYPE_SHELLY1MINI), //
            Map.entry(SHELLYDT_MINIG4_1, THING_TYPE_SHELLY1MINI), //
            Map.entry(SHELLYDT_MINIPM, THING_TYPE_SHELLYPMMINI), //
            Map.entry(SHELLYDT_MINIG3_PM, THING_TYPE_SHELLYPMMINI),
            Map.entry(SHELLYDT_MINIG4_PM, THING_TYPE_SHELLYPMMINI),
            Map.entry(SHELLYDT_MINI1PM, THING_TYPE_SHELLY1PMMINI),
            Map.entry(SHELLYDT_MINIG3_1PM, THING_TYPE_SHELLY1PMMINI),
            Map.entry(SHELLYDT_MINIG4_1PM, THING_TYPE_SHELLY1PMMINI),

            // Pro Series
            Map.entry(SHELLYDT_PRO1, THING_TYPE_SHELLYPRO1), //
            Map.entry(SHELLYDT_PRO1_2, THING_TYPE_SHELLYPRO1), //
            Map.entry(SHELLYDT_PRO1_3, THING_TYPE_SHELLYPRO1), //
            Map.entry(SHELLYDT_PRO1PM, THING_TYPE_SHELLYPRO1PM), //
            Map.entry(SHELLYDT_PRO1PM_2, THING_TYPE_SHELLYPRO1PM),
            Map.entry(SHELLYDT_PRO1PM_3, THING_TYPE_SHELLYPRO1PM), //
            Map.entry(SHELLYDT_PRO1CB, THING_TYPE_SHELLYPRO1CB), //
            Map.entry(SHELLYDT_PRO2, THING_TYPE_SHELLYPRO2_RELAY),
            Map.entry(SHELLYDT_PRO2_2, THING_TYPE_SHELLYPRO2_RELAY),
            Map.entry(SHELLYDT_PRO2_3, THING_TYPE_SHELLYPRO2_RELAY), //
            Map.entry(SHELLYDT_PRO3, THING_TYPE_SHELLYPRO3), //
            Map.entry(SHELLYDT_PROEM50, THING_TYPE_SHELLYPROEM50), //
            Map.entry(SHELLYDT_PRO3EM, THING_TYPE_SHELLYPRO3EM), //
            Map.entry(SHELLYDT_PRO4PM, THING_TYPE_SHELLYPRO4PM), //
            Map.entry(SHELLYDT_PRO4PM_2, THING_TYPE_SHELLYPRO4PM), //
            Map.entry(SHELLYDT_4PRO, THING_TYPE_SHELLYPRO4PM), //

            // BLU Series
            Map.entry(SHELLYDT_BLUBUTTON, THING_TYPE_SHELLYBLUBUTTON),
            Map.entry(SHELLYDT_BLUDW, THING_TYPE_SHELLYBLUDW),
            Map.entry(SHELLYDT_BLUMOTION, THING_TYPE_SHELLYBLUMOTION),
            Map.entry(SHELLYDT_BLUHT, THING_TYPE_SHELLYBLUHT), //
            Map.entry(SHELLYDT_BLUGW, THING_TYPE_SHELLYBLUGW), //
            Map.entry(SHELLYDT_BLUGWG3, THING_TYPE_SHELLYBLUGW),

            // Wall displays
            Map.entry(SHELLYDT_PLUSWALLDISPLAY, THING_TYPE_SHELLYPLUSWALLDISPLAY));

    private static final Map<String, ThingTypeUID> RELAY_THING_TYPE_BY_DEVICE_TYPE = Map.ofEntries(
            // Plus Series
            Map.entry(SHELLYDT_PLUS2PM, THING_TYPE_SHELLYPLUS2PM_RELAY),
            Map.entry(SHELLYDT_PLUS2PM_2, THING_TYPE_SHELLYPLUS2PM_RELAY),
            Map.entry(SHELLYDT_PLUS2PMUL, THING_TYPE_SHELLYPLUS2PM_RELAY),
            Map.entry(SHELLYDT_PLUS2PMG3, THING_TYPE_SHELLYPLUS2PM_RELAY),
            // Pro Series
            Map.entry(SHELLYDT_PRO2PM, THING_TYPE_SHELLYPRO2PM_RELAY),
            Map.entry(SHELLYDT_PRO2PM_2, THING_TYPE_SHELLYPRO2PM_RELAY),
            Map.entry(SHELLYDT_PRO2PM_3, THING_TYPE_SHELLYPRO2PM_RELAY));

    private static final Map<String, ThingTypeUID> ROLLER_THING_TYPE_BY_DEVICE_TYPE = Map.ofEntries(
            // Plus Series
            Map.entry(SHELLYDT_PLUS2PM, THING_TYPE_SHELLYPLUS2PM_ROLLER),
            Map.entry(SHELLYDT_PLUS2PM_2, THING_TYPE_SHELLYPLUS2PM_ROLLER),
            Map.entry(SHELLYDT_PLUS2PMUL, THING_TYPE_SHELLYPLUS2PM_ROLLER),
            Map.entry(SHELLYDT_PLUS2PMG3, THING_TYPE_SHELLYPLUS2PM_ROLLER),
            // Pro Series
            Map.entry(SHELLYDT_PRO2PM, THING_TYPE_SHELLYPRO2PM_ROLLER),
            Map.entry(SHELLYDT_PRO2PM_2, THING_TYPE_SHELLYPRO2PM_ROLLER),
            Map.entry(SHELLYDT_PRO2PM_3, THING_TYPE_SHELLYPRO2PM_ROLLER));

    private static final Map<String, ThingTypeUID> THING_TYPE_BY_SERVICE_NAME = Map.ofEntries(
            // Shelly Gen1
            Map.entry(THING_TYPE_SHELLY1_STR, THING_TYPE_SHELLY1),
            Map.entry(THING_TYPE_SHELLY1PM_STR, THING_TYPE_SHELLY1PM),
            Map.entry(THING_TYPE_SHELLY1L_STR, THING_TYPE_SHELLY1L),
            Map.entry(THING_TYPE_SHELLY3EM_STR, THING_TYPE_SHELLY3EM),
            Map.entry(THING_TYPE_SHELLYEM_STR, THING_TYPE_SHELLYEM),
            Map.entry(THING_TYPE_SHELLY4PRO_STR, THING_TYPE_SHELLY4PRO),
            Map.entry(THING_TYPE_SHELLYDIMMER2_STR, THING_TYPE_SHELLYDIMMER2),
            Map.entry(THING_TYPE_SHELLYDIMMER_STR, THING_TYPE_SHELLYDIMMER),
            Map.entry(THING_TYPE_SHELLYIX3_STR, THING_TYPE_SHELLYIX3),
            Map.entry(THING_TYPE_SHELLYDUORGBW_STR, THING_TYPE_SHELLYDUORGBW),
            Map.entry(THING_TYPE_SHELLYVINTAGE_STR, THING_TYPE_SHELLYVINTAGE),
            Map.entry(THING_TYPE_SHELLYBULB_STR, THING_TYPE_SHELLYBULB),
            Map.entry(THING_TYPE_SHELLYDUO_STR, THING_TYPE_SHELLYDUO),
            Map.entry(THING_TYPE_SHELLYHT_STR, THING_TYPE_SHELLYHT),
            Map.entry(THING_TYPE_SHELLYSMOKE_STR, THING_TYPE_SHELLYSMOKE),
            Map.entry(THING_TYPE_SHELLYGAS_STR, THING_TYPE_SHELLYGAS),
            Map.entry(THING_TYPE_SHELLYFLOOD_STR, THING_TYPE_SHELLYFLOOD),
            Map.entry(THING_TYPE_SHELLYTRV_STR, THING_TYPE_SHELLYTRV),
            Map.entry(THING_TYPE_SHELLYDOORWIN_STR, THING_TYPE_SHELLYDOORWIN),
            Map.entry(THING_TYPE_SHELLYDOORWIN2_STR, THING_TYPE_SHELLYDOORWIN2),
            Map.entry(THING_TYPE_SHELLYSENSE_STR, THING_TYPE_SHELLYSENSE),
            Map.entry(THING_TYPE_SHELLYEYE_STR, THING_TYPE_SHELLYEYE),
            Map.entry(THING_TYPE_SHELLYBUTTON1_STR, THING_TYPE_SHELLYBUTTON1),
            Map.entry(THING_TYPE_SHELLYBUTTON2_STR, THING_TYPE_SHELLYBUTTON2),
            Map.entry(THING_TYPE_SHELLYUNI_STR, THING_TYPE_SHELLYUNI),
            Map.entry(THING_TYPE_SHELLYMOTION2_STR, THING_TYPE_SHELLYMOTION),

            // Shelly Plus
            Map.entry(THING_TYPE_SHELLYPLUS1_STR, THING_TYPE_SHELLYPLUS1),
            Map.entry(THING_TYPE_SHELLYPLUS1G3_STR, THING_TYPE_SHELLYPLUS1),
            Map.entry(THING_TYPE_SHELLYPLUS1G4_STR, THING_TYPE_SHELLYPLUS1),
            Map.entry(THING_TYPE_SHELLYPLUS1PM_STR, THING_TYPE_SHELLYPLUS1PM),
            Map.entry(THING_TYPE_SHELLYPLUS1PMG3_STR, THING_TYPE_SHELLYPLUS1PM),
            Map.entry(THING_TYPE_SHELLYPLUS1PMG4_STR, THING_TYPE_SHELLYPLUS1PM),
            Map.entry(THING_TYPE_SHELLYPLUS2PM_RELAY_STR, THING_TYPE_SHELLYPLUS2PM_RELAY),
            Map.entry(THING_TYPE_SHELLYPLUS2PM_ROLLER_STR, THING_TYPE_SHELLYPLUS2PM_ROLLER),
            Map.entry(SVC_TYPE_SHELLYPLUSPLUGUS_STR, THING_TYPE_SHELLYPLUSPLUGUS),
            Map.entry(THING_TYPE_SHELLYPLUSPLUGS_STR, THING_TYPE_SHELLYPLUSPLUGS),
            Map.entry(THING_TYPE_SHELLYPLUSPLUGUS_STR, THING_TYPE_SHELLYPLUSPLUGUS),
            Map.entry(THING_TYPE_SHELLYPLUSI4_STR, THING_TYPE_SHELLYPLUSI4),
            Map.entry(THING_TYPE_SHELLYPLUSI4G3_STR, THING_TYPE_SHELLYPLUSI4),
            Map.entry(THING_TYPE_SHELLYPLUSI4DC_STR, THING_TYPE_SHELLYPLUSI4DC),
            Map.entry(THING_TYPE_SHELLYPLUSHT_STR, THING_TYPE_SHELLYPLUSHT),
            Map.entry(THING_TYPE_SHELLYPLUSSMOKE_STR, THING_TYPE_SHELLYPLUSSMOKE),
            Map.entry(THING_TYPE_SHELLYPLUSUNI_STR, THING_TYPE_SHELLYPLUSUNI),
            Map.entry(THING_TYPE_SHELLYPLUSDIMMERUS_STR, THING_TYPE_SHELLYPLUSDIMMERUS),
            Map.entry(THING_TYPE_SHELLYPLUSDIMMER10V_STR, THING_TYPE_SHELLYPLUSDIMMER10V),
            Map.entry(THING_TYPE_SHELLYPLUSDIMMER0110VG3_STR, THING_TYPE_SHELLYPLUSDIMMER10V),
            Map.entry(THING_TYPE_SHELLYPLUSRGBWPM_STR, THING_TYPE_SHELLYPLUSRGBWPM),
            Map.entry(THING_TYPE_SHELLYPLUSWALLDISPLAY_STR, THING_TYPE_SHELLYPLUSWALLDISPLAY),

            // Shelly Plus Mini
            Map.entry(THING_TYPE_SHELLY1MINI_STR, THING_TYPE_SHELLY1MINI),
            Map.entry(THING_TYPE_SHELLYMINI1G3_STR, THING_TYPE_SHELLY1MINI),
            Map.entry(THING_TYPE_SHELLYMINI1G4_STR, THING_TYPE_SHELLY1MINI),
            Map.entry(THING_TYPE_SHELLYPMMINI_STR, THING_TYPE_SHELLYPMMINI),
            Map.entry(THING_TYPE_SHELLYPMMINIG3_STR, THING_TYPE_SHELLYPMMINI),
            Map.entry(THING_TYPE_SHELLYPMMINIG4_STR, THING_TYPE_SHELLYPMMINI),
            Map.entry(THING_TYPE_SHELLY1PMMINI_STR, THING_TYPE_SHELLY1PMMINI),

            // Shelly Pro
            Map.entry(THING_TYPE_SHELLYPRO1_STR, THING_TYPE_SHELLYPRO1),
            Map.entry(THING_TYPE_SHELLYPRO1PM_STR, THING_TYPE_SHELLYPRO1PM),
            Map.entry(THING_TYPE_SHELLYPRO1CB_STR, THING_TYPE_SHELLYPRO1CB),
            Map.entry(THING_TYPE_SHELLYPRO2PM_RELAY_STR, THING_TYPE_SHELLYPRO2PM_RELAY),
            Map.entry(THING_TYPE_SHELLYPRO2PM_ROLLER_STR, THING_TYPE_SHELLYPRO2PM_ROLLER),
            Map.entry(THING_TYPE_SHELLYPRO2_RELAY_STR, THING_TYPE_SHELLYPRO2_RELAY),
            Map.entry(THING_TYPE_SHELLYPROEM50_STR, THING_TYPE_SHELLYPROEM50),
            Map.entry(THING_TYPE_SHELLYPRO3EM_STR, THING_TYPE_SHELLYPRO3EM),
            Map.entry(THING_TYPE_SHELLYPRO3_STR, THING_TYPE_SHELLYPRO3),
            Map.entry(THING_TYPE_SHELLYPRO4PM_STR, THING_TYPE_SHELLYPRO4PM),

            // Shelly BLU
            Map.entry(THING_TYPE_SHELLYBLUBUTTON_STR, THING_TYPE_SHELLYBLUBUTTON),
            Map.entry(THING_TYPE_SHELLYBLUDW_STR, THING_TYPE_SHELLYBLUDW),
            Map.entry(THING_TYPE_SHELLYBLUMOTION_STR, THING_TYPE_SHELLYBLUMOTION),
            Map.entry(THING_TYPE_SHELLYBLUHT_STR, THING_TYPE_SHELLYBLUHT),
            Map.entry(THING_TYPE_SHELLYBLUGW_STR, THING_TYPE_SHELLYBLUGW),
            Map.entry(THING_TYPE_SHELLYBLUGWG3_STR, THING_TYPE_SHELLYBLUGW),

            // Password protected device
            Map.entry(THING_TYPE_SHELLYPROTECTED_STR, THING_TYPE_SHELLYPROTECTED));

    public static ThingUID getThingUID(String serviceName) {
        return getThingUID(serviceName, "", "");
    }

    public static ThingUID getThingUID(String serviceName, String deviceType, String mode) {
        String deviceId = getDeviceIdOrThrow(serviceName);
        return new ThingUID(getThingTypeUID(serviceName, deviceType, mode), deviceId);
    }

    public static ThingUID getThingUIDForUnknown(String serviceName, String deviceType, String mode) {
        String deviceId = getDeviceIdOrThrow(serviceName);
        return new ThingUID(getThingTypeUID(THING_TYPE_SHELLYPROTECTED_STR + "-" + deviceId, deviceType, mode),
                deviceId);
    }

    private static String getDeviceIdOrThrow(String serviceName) {
        String deviceId = substringAfterLast(serviceName, "-");
        if (deviceId.isEmpty()) {
            throw new IllegalArgumentException("Invalid serviceName format: " + serviceName);
        }
        return deviceId;
    }

    public static ThingTypeUID getThingTypeUID(String serviceName, String deviceType, String mode) {
        if (THING_TYPE_SHELLYPROTECTED_STR.equals(serviceName)) {
            return THING_TYPE_SHELLYPROTECTED;
        }
        String serviceNameLowerCase = serviceName.toLowerCase();
        String type = substringBefore(serviceNameLowerCase, "-");
        if (type.isEmpty()) {
            throw new IllegalArgumentException("Invalid serviceName format: " + serviceName);
        }

        // First check for special handling
        if (serviceNameLowerCase.startsWith(THING_TYPE_SHELLY25_PREFIX)) { // Shelly v2.5
            return getRelayOrRollerType(THING_TYPE_SHELLY25_RELAY, THING_TYPE_SHELLY25_ROLLER, mode);
        }
        if (serviceNameLowerCase.startsWith(THING_TYPE_SHELLY2_PREFIX)) { // Shelly v2
            return getRelayOrRollerType(THING_TYPE_SHELLY2_RELAY, THING_TYPE_SHELLY2_ROLLER, mode);
        }
        if (serviceNameLowerCase.startsWith(THING_TYPE_SHELLYPLUG_STR) && !serviceNameLowerCase.contains("plugus")
                && !serviceNameLowerCase.contains("plugsg3")) {
            // shellyplug-s needs to be mapped to shellyplugs to follow the schema
            // for the thing types: <thing type>-<mode>
            if (serviceNameLowerCase.startsWith(THING_TYPE_SHELLYPLUGS_STR) || serviceNameLowerCase.contains("-s")) {
                return THING_TYPE_SHELLYPLUGS;
            }
            if (serviceNameLowerCase.startsWith(THING_TYPE_SHELLYPLUGU1_STR)) {
                return THING_TYPE_SHELLYPLUGU1;
            }
            return THING_TYPE_SHELLYPLUG;
        }
        if (serviceNameLowerCase.startsWith(THING_TYPE_SHELLYRGBW2_PREFIX)) {
            return SHELLY_MODE_COLOR.equals(mode) ? THING_TYPE_SHELLYRGBW2_COLOR : THING_TYPE_SHELLYRGBW2_WHITE;
        }
        if (serviceNameLowerCase.startsWith(THING_TYPE_SHELLYMOTION_STR)) {
            // depending on firmware release the Motion advertises under shellymotion-xxx or shellymotionsensor-xxxx
            return THING_TYPE_SHELLYMOTION;
        }

        if (!deviceType.isEmpty()) {
            Map<String, ThingTypeUID> deviceTypeMap = switch (mode) {
                case SHELLY_MODE_RELAY -> RELAY_THING_TYPE_BY_DEVICE_TYPE;
                case SHELLY_MODE_ROLLER -> ROLLER_THING_TYPE_BY_DEVICE_TYPE;
                default -> THING_TYPE_BY_DEVICE_TYPE;
            };

            ThingTypeUID res = deviceTypeMap.get(deviceType);
            if (res != null) {
                return res;
            }
        }

        return THING_TYPE_BY_SERVICE_NAME.getOrDefault(type, THING_TYPE_SHELLYUNKNOWN);
    }

    private static ThingTypeUID getRelayOrRollerType(ThingTypeUID relayType, ThingTypeUID rollerType, String mode) {
        return SHELLY_MODE_RELAY.equals(mode) ? relayType : rollerType;
    }

    public static boolean isValidShellyServiceName(String serviceName) {
        return SHELLY_SERVICE_NAME_PATTERN.matcher(serviceName).matches();
    }
}
