package com.example.footmatch.modelo.pojos;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0007H\u00c6\u0003J\'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001a"}, d2 = {"Lcom/example/footmatch/modelo/pojos/Penalty;", "Ljava/io/Serializable;", "player", "Lcom/example/footmatch/modelo/pojos/Player;", "team", "Lcom/example/footmatch/modelo/pojos/Team;", "scored", "", "(Lcom/example/footmatch/modelo/pojos/Player;Lcom/example/footmatch/modelo/pojos/Team;Z)V", "getPlayer", "()Lcom/example/footmatch/modelo/pojos/Player;", "getScored", "()Z", "getTeam", "()Lcom/example/footmatch/modelo/pojos/Team;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "app_debug"})
public final class Penalty implements java.io.Serializable {
    @com.google.gson.annotations.SerializedName(value = "player")
    @org.jetbrains.annotations.NotNull
    private final com.example.footmatch.modelo.pojos.Player player = null;
    @com.google.gson.annotations.SerializedName(value = "team")
    @org.jetbrains.annotations.NotNull
    private final com.example.footmatch.modelo.pojos.Team team = null;
    @com.google.gson.annotations.SerializedName(value = "scored")
    private final boolean scored = false;
    
    public Penalty(@org.jetbrains.annotations.NotNull
    com.example.footmatch.modelo.pojos.Player player, @org.jetbrains.annotations.NotNull
    com.example.footmatch.modelo.pojos.Team team, boolean scored) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.footmatch.modelo.pojos.Player getPlayer() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.footmatch.modelo.pojos.Team getTeam() {
        return null;
    }
    
    public final boolean getScored() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.footmatch.modelo.pojos.Player component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.footmatch.modelo.pojos.Team component2() {
        return null;
    }
    
    public final boolean component3() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.footmatch.modelo.pojos.Penalty copy(@org.jetbrains.annotations.NotNull
    com.example.footmatch.modelo.pojos.Player player, @org.jetbrains.annotations.NotNull
    com.example.footmatch.modelo.pojos.Team team, boolean scored) {
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