package com.website.qlts.view;

import com.website.qlts.entity.Assets;
import com.website.qlts.entity.RevokeHistory;

public class AssetRevoke {
    private Assets assets;
    private RevokeHistory revokeHistory;

    public Assets getAssets() {
        return assets;
    }

    public void setAssets(Assets assets) {
        this.assets = assets;
    }

    public RevokeHistory getRevokeHistory() {
        return revokeHistory;
    }

    public void setRevokeHistory(RevokeHistory revokeHistory) {
        this.revokeHistory = revokeHistory;
    }
}
