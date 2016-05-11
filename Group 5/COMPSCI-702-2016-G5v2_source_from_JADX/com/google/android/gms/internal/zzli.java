package com.google.android.gms.internal;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.Cast.CastApi;
import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.CastStatusCodes;
import com.google.android.gms.cast.RemoteMediaPlayer;
import com.google.android.gms.cast.games.GameManagerClient;
import com.google.android.gms.cast.games.GameManagerClient.GameManagerInstanceResult;
import com.google.android.gms.cast.games.GameManagerClient.GameManagerResult;
import com.google.android.gms.cast.games.GameManagerClient.Listener;
import com.google.android.gms.cast.games.GameManagerState;
import com.google.android.gms.cast.games.PlayerInfo;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.cast.internal.zzl;
import com.google.android.gms.cast.internal.zzo;
import com.google.android.gms.cast.internal.zzp;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;
import com.woop.tryreverseengineerthis.BuildConfig;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class zzli extends com.google.android.gms.cast.internal.zzc {
    static final String NAMESPACE;
    private static final zzl zzaaf;
    private final List<zzp> zzacA;
    private final String zzacB;
    private final CastApi zzacC;
    private final GoogleApiClient zzacD;
    private zzlj zzacE;
    private boolean zzacF;
    private GameManagerState zzacG;
    private GameManagerState zzacH;
    private String zzacI;
    private JSONObject zzacJ;
    private long zzacK;
    private Listener zzacL;
    private String zzacM;
    private final Map<String, String> zzacz;
    private final SharedPreferences zzvx;

    /* renamed from: com.google.android.gms.internal.zzli.4 */
    class C08464 implements ResultCallback<Status> {
        final /* synthetic */ zzli zzacN;
        final /* synthetic */ long zzacS;

        C08464(zzli com_google_android_gms_internal_zzli, long j) {
            this.zzacN = com_google_android_gms_internal_zzli;
            this.zzacS = j;
        }

        public /* synthetic */ void onResult(Result result) {
            zzp((Status) result);
        }

        public void zzp(Status status) {
            if (!status.isSuccess()) {
                this.zzacN.zzb(this.zzacS, status.getStatusCode());
            }
        }
    }

    private static final class zzd implements GameManagerInstanceResult {
        private final Status zzUX;
        private final GameManagerClient zzacV;

        zzd(Status status, GameManagerClient gameManagerClient) {
            this.zzUX = status;
            this.zzacV = gameManagerClient;
        }

        public GameManagerClient getGameManagerClient() {
            return this.zzacV;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static final class zze implements GameManagerResult {
        private final Status zzUX;
        private final String zzacX;
        private final long zzacY;
        private final JSONObject zzacZ;

        zze(Status status, String str, long j, JSONObject jSONObject) {
            this.zzUX = status;
            this.zzacX = str;
            this.zzacY = j;
            this.zzacZ = jSONObject;
        }

        public JSONObject getExtraMessageData() {
            return this.zzacZ;
        }

        public String getPlayerId() {
            return this.zzacX;
        }

        public long getRequestId() {
            return this.zzacY;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    public abstract class zzb<R extends Result> extends com.google.android.gms.cast.internal.zzb<R> {
        final /* synthetic */ zzli zzacN;
        protected zzo zzacm;

        public zzb(zzli com_google_android_gms_internal_zzli) {
            this.zzacN = com_google_android_gms_internal_zzli;
            super(com_google_android_gms_internal_zzli.zzacD);
        }

        public abstract void execute();

        protected void zza(com.google.android.gms.cast.internal.zze com_google_android_gms_cast_internal_zze) {
            execute();
        }

        public zzo zznW() {
            return this.zzacm;
        }
    }

    public abstract class zza extends zzb<GameManagerResult> {
        final /* synthetic */ zzli zzacN;

        /* renamed from: com.google.android.gms.internal.zzli.zza.1 */
        class C08471 implements zzo {
            final /* synthetic */ zzli zzacT;
            final /* synthetic */ zza zzacU;

            C08471(zza com_google_android_gms_internal_zzli_zza, zzli com_google_android_gms_internal_zzli) {
                this.zzacU = com_google_android_gms_internal_zzli_zza;
                this.zzacT = com_google_android_gms_internal_zzli;
            }

            public void zza(long j, int i, Object obj) {
                if (obj == null) {
                    try {
                        this.zzacU.zza(new zze(new Status(i, null, null), null, j, null));
                        return;
                    } catch (ClassCastException e) {
                        this.zzacU.zza(this.zzacU.zzr(new Status(13)));
                        return;
                    }
                }
                zzlk com_google_android_gms_internal_zzlk = (zzlk) obj;
                String playerId = com_google_android_gms_internal_zzlk.getPlayerId();
                if (i == 0 && playerId != null) {
                    this.zzacU.zzacN.zzacM = playerId;
                }
                this.zzacU.zza(new zze(new Status(i, com_google_android_gms_internal_zzlk.zznZ(), null), playerId, com_google_android_gms_internal_zzlk.getRequestId(), com_google_android_gms_internal_zzlk.getExtraMessageData()));
            }

            public void zzy(long j) {
                this.zzacU.zza(this.zzacU.zzr(new Status(RemoteMediaPlayer.STATUS_REPLACED)));
            }
        }

        public zza(zzli com_google_android_gms_internal_zzli) {
            this.zzacN = com_google_android_gms_internal_zzli;
            super(com_google_android_gms_internal_zzli);
            this.zzacm = new C08471(this, com_google_android_gms_internal_zzli);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzr(status);
        }

        public GameManagerResult zzr(Status status) {
            return new zze(status, null, -1, null);
        }
    }

    public abstract class zzc extends zzb<GameManagerInstanceResult> {
        final /* synthetic */ zzli zzacN;
        private GameManagerClient zzacV;

        /* renamed from: com.google.android.gms.internal.zzli.zzc.1 */
        class C08481 implements zzo {
            final /* synthetic */ zzli zzacT;
            final /* synthetic */ zzc zzacW;

            C08481(zzc com_google_android_gms_internal_zzli_zzc, zzli com_google_android_gms_internal_zzli) {
                this.zzacW = com_google_android_gms_internal_zzli_zzc;
                this.zzacT = com_google_android_gms_internal_zzli;
            }

            public void zza(long j, int i, Object obj) {
                if (obj == null) {
                    try {
                        this.zzacW.zza(new zzd(new Status(i, null, null), this.zzacW.zzacV));
                        return;
                    } catch (ClassCastException e) {
                        this.zzacW.zza(this.zzacW.zzs(new Status(13)));
                        return;
                    }
                }
                zzlk com_google_android_gms_internal_zzlk = (zzlk) obj;
                zzlj zzod = com_google_android_gms_internal_zzlk.zzod();
                if (zzod == null || zzf.zza("1.0.0", zzod.getVersion())) {
                    this.zzacW.zza(new zzd(new Status(i, com_google_android_gms_internal_zzlk.zznZ(), null), this.zzacW.zzacV));
                    return;
                }
                this.zzacW.zza(this.zzacW.zzs(new Status(GameManagerClient.STATUS_INCORRECT_VERSION, String.format(Locale.ROOT, "Incorrect Game Manager SDK version. Receiver: %s Sender: %s", new Object[]{zzod.getVersion(), "1.0.0"}))));
                this.zzacW.zzacN.zzacE = null;
            }

            public void zzy(long j) {
                this.zzacW.zza(this.zzacW.zzs(new Status(RemoteMediaPlayer.STATUS_REPLACED)));
            }
        }

        public zzc(zzli com_google_android_gms_internal_zzli, GameManagerClient gameManagerClient) {
            this.zzacN = com_google_android_gms_internal_zzli;
            super(com_google_android_gms_internal_zzli);
            this.zzacV = gameManagerClient;
            this.zzacm = new C08481(this, com_google_android_gms_internal_zzli);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzs(status);
        }

        public GameManagerInstanceResult zzs(Status status) {
            return new zzd(status, null);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzli.1 */
    class C13101 extends zzc {
        final /* synthetic */ zzli zzacN;

        /* renamed from: com.google.android.gms.internal.zzli.1.1 */
        class C08451 implements MessageReceivedCallback {
            final /* synthetic */ C13101 zzacO;

            C08451(C13101 c13101) {
                this.zzacO = c13101;
            }

            public void onMessageReceived(CastDevice castDevice, String namespace, String message) {
                this.zzacO.zzacN.zzcf(message);
            }
        }

        C13101(zzli com_google_android_gms_internal_zzli, GameManagerClient gameManagerClient) {
            this.zzacN = com_google_android_gms_internal_zzli;
            super(com_google_android_gms_internal_zzli, gameManagerClient);
        }

        public void execute() {
            try {
                this.zzacN.zzacC.setMessageReceivedCallbacks(this.zzacN.zzacD, this.zzacN.getNamespace(), new C08451(this));
                this.zzacN.zznU();
                this.zzacN.zznT();
                this.zzacN.zza(null, 1100, null, zznW());
            } catch (IOException e) {
                zznW().zza(-1, 8, null);
            } catch (IllegalStateException e2) {
                zznW().zza(-1, 8, null);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzli.2 */
    class C13112 extends zza {
        final /* synthetic */ zzli zzacN;
        final /* synthetic */ int zzacP;
        final /* synthetic */ String zzacQ;
        final /* synthetic */ JSONObject zzacR;

        C13112(zzli com_google_android_gms_internal_zzli, int i, String str, JSONObject jSONObject) {
            this.zzacN = com_google_android_gms_internal_zzli;
            this.zzacP = i;
            this.zzacQ = str;
            this.zzacR = jSONObject;
            super(com_google_android_gms_internal_zzli);
        }

        public void execute() {
            int zzbh = zzll.zzbh(this.zzacP);
            if (zzbh == 0) {
                zznW().zza(-1, GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE, null);
                zzli.zzaaf.zzf("sendPlayerRequest for unsupported playerState: %d", Integer.valueOf(this.zzacP));
                return;
            }
            this.zzacN.zza(this.zzacQ, zzbh, this.zzacR, zznW());
        }
    }

    /* renamed from: com.google.android.gms.internal.zzli.3 */
    class C13123 extends zza {
        final /* synthetic */ zzli zzacN;
        final /* synthetic */ String zzacQ;
        final /* synthetic */ JSONObject zzacR;

        C13123(zzli com_google_android_gms_internal_zzli, String str, JSONObject jSONObject) {
            this.zzacN = com_google_android_gms_internal_zzli;
            this.zzacQ = str;
            this.zzacR = jSONObject;
            super(com_google_android_gms_internal_zzli);
        }

        public void execute() {
            this.zzacN.zza(this.zzacQ, 6, this.zzacR, zznW());
        }
    }

    static {
        NAMESPACE = zzf.zzci("com.google.cast.games");
        zzaaf = new zzl("GameManagerChannel");
    }

    public zzli(GoogleApiClient googleApiClient, String str, CastApi castApi) throws IllegalArgumentException, IllegalStateException {
        super(NAMESPACE, "CastGameManagerChannel", null);
        this.zzacz = new ConcurrentHashMap();
        this.zzacF = false;
        this.zzacK = 0;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("castSessionId cannot be null.");
        } else if (googleApiClient != null && googleApiClient.isConnected() && googleApiClient.hasConnectedApi(Cast.API)) {
            this.zzacA = new ArrayList();
            this.zzacB = str;
            this.zzacC = castApi;
            this.zzacD = googleApiClient;
            this.zzvx = r0.getApplicationContext().getSharedPreferences(String.format(Locale.ROOT, "%s.%s", new Object[]{googleApiClient.getContext().getApplicationContext().getPackageName(), "game_manager_channel_data"}), 0);
            this.zzacH = null;
            this.zzacG = new zzlm(0, 0, BuildConfig.FLAVOR, null, new ArrayList(), BuildConfig.FLAVOR, -1);
        } else {
            throw new IllegalArgumentException("googleApiClient needs to be connected and contain the Cast.API API.");
        }
    }

    private JSONObject zza(long j, String str, int i, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("requestId", j);
            jSONObject2.put("type", i);
            jSONObject2.put("extraMessageData", jSONObject);
            jSONObject2.put("playerId", str);
            jSONObject2.put("playerToken", zzce(str));
            return jSONObject2;
        } catch (JSONException e) {
            zzaaf.zzf("JSONException when trying to create a message: %s", e.getMessage());
            return null;
        }
    }

    private synchronized void zza(zzlk com_google_android_gms_internal_zzlk) {
        Object obj = 1;
        synchronized (this) {
            if (com_google_android_gms_internal_zzlk.zznY() != 1) {
                obj = null;
            }
            this.zzacH = this.zzacG;
            if (!(obj == null || com_google_android_gms_internal_zzlk.zzod() == null)) {
                this.zzacE = com_google_android_gms_internal_zzlk.zzod();
            }
            if (isInitialized()) {
                Collection arrayList = new ArrayList();
                for (zzlo com_google_android_gms_internal_zzlo : com_google_android_gms_internal_zzlk.zzoa()) {
                    String playerId = com_google_android_gms_internal_zzlo.getPlayerId();
                    arrayList.add(new zzln(playerId, com_google_android_gms_internal_zzlo.getPlayerState(), com_google_android_gms_internal_zzlo.getPlayerData(), this.zzacz.containsKey(playerId)));
                }
                this.zzacG = new zzlm(com_google_android_gms_internal_zzlk.getLobbyState(), com_google_android_gms_internal_zzlk.getGameplayState(), com_google_android_gms_internal_zzlk.zzob(), com_google_android_gms_internal_zzlk.getGameData(), arrayList, this.zzacE.zznX(), this.zzacE.getMaxPlayers());
                PlayerInfo player = this.zzacG.getPlayer(com_google_android_gms_internal_zzlk.getPlayerId());
                if (player != null && player.isControllable() && com_google_android_gms_internal_zzlk.zznY() == 2) {
                    this.zzacI = com_google_android_gms_internal_zzlk.getPlayerId();
                    this.zzacJ = com_google_android_gms_internal_zzlk.getExtraMessageData();
                }
            }
        }
    }

    private void zza(String str, int i, JSONObject jSONObject, zzo com_google_android_gms_cast_internal_zzo) {
        long j = 1 + this.zzacK;
        this.zzacK = j;
        JSONObject zza = zza(j, str, i, jSONObject);
        if (zza == null) {
            com_google_android_gms_cast_internal_zzo.zza(-1, GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE, null);
            zzaaf.zzf("Not sending request because it was invalid.", new Object[0]);
            return;
        }
        zzp com_google_android_gms_cast_internal_zzp = new zzp(30000);
        com_google_android_gms_cast_internal_zzp.zza(j, com_google_android_gms_cast_internal_zzo);
        this.zzacA.add(com_google_android_gms_cast_internal_zzp);
        zzW(true);
        this.zzacC.sendMessage(this.zzacD, getNamespace(), zza.toString()).setResultCallback(new C08464(this, j));
    }

    private void zzb(long j, int i, Object obj) {
        Iterator it = this.zzacA.iterator();
        while (it.hasNext()) {
            if (((zzp) it.next()).zzc(j, i, obj)) {
                it.remove();
            }
        }
    }

    private int zzbg(int i) {
        switch (i) {
            case Barcode.ALL_FORMATS /*0*/:
                return 0;
            case CompletionEvent.STATUS_FAILURE /*1*/:
                return GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE;
            case CompletionEvent.STATUS_CONFLICT /*2*/:
                return CastStatusCodes.NOT_ALLOWED;
            case CompletionEvent.STATUS_CANCELED /*3*/:
                return GameManagerClient.STATUS_INCORRECT_VERSION;
            case Barcode.PHONE /*4*/:
                return GameManagerClient.STATUS_TOO_MANY_PLAYERS;
            default:
                zzaaf.zzf("Unknown GameManager protocol status code: " + i, new Object[0]);
                return 13;
        }
    }

    private synchronized void zznR() throws IllegalStateException {
        if (!isInitialized()) {
            throw new IllegalStateException("Attempted to perform an operation on the GameManagerChannel before it is initialized.");
        } else if (isDisposed()) {
            throw new IllegalStateException("Attempted to perform an operation on the GameManagerChannel after it has been disposed.");
        }
    }

    private void zznS() {
        if (this.zzacL != null) {
            if (!(this.zzacH == null || this.zzacG.equals(this.zzacH))) {
                this.zzacL.onStateChanged(this.zzacG, this.zzacH);
            }
            if (!(this.zzacJ == null || this.zzacI == null)) {
                this.zzacL.onGameMessageReceived(this.zzacI, this.zzacJ);
            }
        }
        this.zzacH = null;
        this.zzacI = null;
        this.zzacJ = null;
    }

    private synchronized void zznT() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("castSessionId", this.zzacB);
            jSONObject.put("playerTokenMap", new JSONObject(this.zzacz));
            this.zzvx.edit().putString("save_data", jSONObject.toString()).commit();
        } catch (JSONException e) {
            zzaaf.zzf("Error while saving data: %s", e.getMessage());
        }
    }

    private synchronized void zznU() {
        String string = this.zzvx.getString("save_data", null);
        if (string != null) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                if (this.zzacB.equals(jSONObject.getString("castSessionId"))) {
                    jSONObject = jSONObject.getJSONObject("playerTokenMap");
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        string = (String) keys.next();
                        this.zzacz.put(string, jSONObject.getString(string));
                    }
                    this.zzacK = 0;
                }
            } catch (JSONException e) {
                zzaaf.zzf("Error while loading data: %s", e.getMessage());
            }
        }
    }

    public synchronized void dispose() throws IllegalStateException {
        if (!this.zzacF) {
            this.zzacG = null;
            this.zzacH = null;
            this.zzacI = null;
            this.zzacJ = null;
            this.zzacF = true;
            try {
                this.zzacC.removeMessageReceivedCallbacks(this.zzacD, getNamespace());
            } catch (IOException e) {
                zzaaf.zzf("Exception while detaching game manager channel.", e);
            }
        }
    }

    public synchronized GameManagerState getCurrentState() throws IllegalStateException {
        zznR();
        return this.zzacG;
    }

    public synchronized String getLastUsedPlayerId() throws IllegalStateException {
        zznR();
        return this.zzacM;
    }

    public synchronized boolean isDisposed() {
        return this.zzacF;
    }

    public synchronized boolean isInitialized() {
        return this.zzacE != null;
    }

    public synchronized void sendGameMessage(String playerId, JSONObject extraMessageData) throws IllegalStateException {
        zznR();
        long j = 1 + this.zzacK;
        this.zzacK = j;
        JSONObject zza = zza(j, playerId, 7, extraMessageData);
        if (zza != null) {
            this.zzacC.sendMessage(this.zzacD, getNamespace(), zza.toString());
        }
    }

    public synchronized PendingResult<GameManagerResult> sendGameRequest(String playerId, JSONObject extraMessageData) throws IllegalStateException {
        zznR();
        return this.zzacD.zzb(new C13123(this, playerId, extraMessageData));
    }

    public synchronized void setListener(Listener listener) {
        this.zzacL = listener;
    }

    public synchronized PendingResult<GameManagerInstanceResult> zza(GameManagerClient gameManagerClient) throws IllegalArgumentException {
        if (gameManagerClient == null) {
            throw new IllegalArgumentException("gameManagerClient can't be null.");
        }
        return this.zzacD.zzb(new C13101(this, gameManagerClient));
    }

    public synchronized PendingResult<GameManagerResult> zza(String str, int i, JSONObject jSONObject) throws IllegalStateException {
        zznR();
        return this.zzacD.zzb(new C13112(this, i, str, jSONObject));
    }

    public void zzb(long j, int i) {
        zzb(j, i, null);
    }

    public synchronized String zzce(String str) throws IllegalStateException {
        return str == null ? null : (String) this.zzacz.get(str);
    }

    public final void zzcf(String str) {
        zzaaf.zzb("message received: %s", str);
        try {
            zzlk zzi = zzlk.zzi(new JSONObject(str));
            if (zzi == null) {
                zzaaf.zzf("Could not parse game manager message from string: %s", str);
            } else if ((isInitialized() || zzi.zzod() != null) && !isDisposed()) {
                int i = zzi.zznY() == 1 ? 1 : 0;
                if (!(i == 0 || TextUtils.isEmpty(zzi.zzoc()))) {
                    this.zzacz.put(zzi.getPlayerId(), zzi.zzoc());
                    zznT();
                }
                if (zzi.getStatusCode() == 0) {
                    zza(zzi);
                } else {
                    zzaaf.zzf("Not updating from game message because the message contains error code: %d", Integer.valueOf(zzi.getStatusCode()));
                }
                int zzbg = zzbg(zzi.getStatusCode());
                if (i != 0) {
                    zzb(zzi.getRequestId(), zzbg, zzi);
                }
                if (isInitialized() && zzbg == 0) {
                    zznS();
                }
            }
        } catch (JSONException e) {
            zzaaf.zzf("Message is malformed (%s); ignoring: %s", e.getMessage(), str);
        }
    }

    protected boolean zzz(long j) {
        boolean z;
        Iterator it = this.zzacA.iterator();
        while (it.hasNext()) {
            if (((zzp) it.next()).zzd(j, 15)) {
                it.remove();
            }
        }
        synchronized (zzp.zzaeB) {
            for (zzp zzoA : this.zzacA) {
                if (zzoA.zzoA()) {
                    z = true;
                    break;
                }
            }
            z = false;
        }
        return z;
    }
}
