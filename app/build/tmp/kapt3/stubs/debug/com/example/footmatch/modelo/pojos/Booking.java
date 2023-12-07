package com.example.footmatch.modelo.pojos;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\tH\u00c6\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u00c6\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u00d6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001e"}, d2 = {"Lcom/example/footmatch/modelo/pojos/Booking;", "Ljava/io/Serializable;", "card", "", "minute", "", "player", "Lcom/example/footmatch/modelo/pojos/Player;", "team", "Lcom/example/footmatch/modelo/pojos/Team;", "(Ljava/lang/String;ILcom/example/footmatch/modelo/pojos/Player;Lcom/example/footmatch/modelo/pojos/Team;)V", "getCard", "()Ljava/lang/String;", "getMinute", "()I", "getPlayer", "()Lcom/example/footmatch/modelo/pojos/Player;", "getTeam", "()Lcom/example/footmatch/modelo/pojos/Team;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "app_debug"})
public final class Booking implements java.io.Serializable {
    @com.google.gson.annotations.SerializedName(value = "card")
    @org.jetbrains.annotations.NotNull
    private final java.lang.String card = null;
    @com.google.gson.annotations.SerializedName(value = "minute")
    private final int minute = 0;
    @com.google.gson.annotations.SerializedName(value = "player")
    @org.jetbrains.annotations.NotNull
    private final com.example.footmatch.modelo.pojos.Player player = null;
    @com.google.gson.annotations.SerializedName(value = "team")
    @org.jetbrains.annotations.NotNull
    private final com.example.footmatch.modelo.pojos.Team team = null;
    
    public Booking(@org.jetbrains.annotations.NotNull
    java.lang.String card, int minute, @org.jetbrains.annotations.NotNull
    com.example.footmatch.modelo.pojos.Player player, @org.jetbrains.annotations.NotNull
    com.example.footmatch.modelo.pojos.Team team) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCard() {
        return null;
    }
    
    public final int getMinute() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.footmatch.modelo.pojos.Player getPlayer() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.footmatch.modelo.pojos.Team getTeam() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    public final int component2() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.footmatch.modelo.pojos.Player component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.footmatch.modelo.pojos.Team component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.footmatch.modelo.pojos.Booking copy(@org.jetbrains.annotations.NotNull
    java.lang.String card, int minute, @org.jetbrains.annotations.NotNull
    com.example.footmatch.modelo.pojos.Player player, @org.jetbrains.annotations.NotNull
    com.example.footmatch.modelo.pojos.Team team) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return null;
    }
}