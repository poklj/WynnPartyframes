package com.wynnpartyframes.partyframes;

import me.bed0.jWynn.WynncraftAPI;
import java.util.List;

class asyncAPI<T> {
    private volatile T Value = null;

    asyncAPI() { }

    public T getValue(){
        return this.Value;
    }

    void Pulldata(String Playername){
        new Thread(() -> {
            this.Value = (T) Partyframes.api.v2().player().stats(Playername).run()[0];
        }).start();
    }
}
