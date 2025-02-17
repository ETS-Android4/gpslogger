/*
 * Copyright (C) 2016 mendhak
 *
 * This file is part of GPSLogger for Android.
 *
 * GPSLogger for Android is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version.
 *
 * GPSLogger for Android is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with GPSLogger for Android.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.mendhak.gpslogger.senders;

import java.io.File;
import java.io.FilenameFilter;
import java.util.List;

public abstract class FileSender implements FilenameFilter {

    public static class SenderNames {
        public static final String AUTOEMAIL = "AUTO_EMAIL_SENDER";
        public static final String DROPBOX = "DROPBOX_SENDER";
        public static final String OPENGTS = "OPENGTS_SENDER";
        public static final String FTP = "FTP_SENDER";
        public static final String OWNCLOUD = "OWNCLOUD_SENDER";
        public static final String SFTP = "SFTP_SENDER";
        public static final String OPENSTREETMAP = "OSM_SENDER";
        public static final String CUSTOMURL = "CUSTOM_URL_SENDER";
    }


    /**
     * Upload or send these given files
     */
    public abstract void uploadFile(List<File> files);

    /**
     * Whether the sender is enabled and ready to be used for manual uploads
     */
    public abstract boolean isAvailable();

    /**
     * Whether the user has enabled this preference for automatic sending
     */
    public abstract boolean hasUserAllowedAutoSending();

    /**
     * Name of the sender. To be used when searching or matching for this among all the senders.
     */
    public abstract String getName();

    /**
     * Whether this sender is available and allowed to automatically send files.
     * It checks both {@link #isAvailable()} and {@link #hasUserAllowedAutoSending()}
     */
    public boolean isAutoSendAvailable() {
        return hasUserAllowedAutoSending() && isAvailable();
    }


}
