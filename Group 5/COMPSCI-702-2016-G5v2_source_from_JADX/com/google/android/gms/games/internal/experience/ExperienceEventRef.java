package com.google.android.gms.games.internal.experience;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.GameRef;

public final class ExperienceEventRef extends zzc implements ExperienceEvent {
    private final GameRef zzaIk;

    public ExperienceEventRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
        if (zzcB("external_game_id")) {
            this.zzaIk = null;
        } else {
            this.zzaIk = new GameRef(this.zzahi, this.zzaje);
        }
    }

    public String getIconImageUrl() {
        return getString("icon_url");
    }
}
