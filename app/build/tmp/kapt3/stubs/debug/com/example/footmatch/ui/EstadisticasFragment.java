package com.example.footmatch.ui;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J&\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/example/footmatch/ui/EstadisticasFragment;", "Landroidx/fragment/app/Fragment;", "()V", "equipo1", "Lcom/example/footmatch/modelo/pojos/HomeTeamX;", "equipo2", "Lcom/example/footmatch/modelo/pojos/AwayTeamX;", "stats", "Lcom/example/footmatch/modelo/pojos/Aggregates;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "Companion", "app_debug"})
public final class EstadisticasFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable
    private com.example.footmatch.modelo.pojos.HomeTeamX equipo1;
    @org.jetbrains.annotations.Nullable
    private com.example.footmatch.modelo.pojos.AwayTeamX equipo2;
    @org.jetbrains.annotations.Nullable
    private com.example.footmatch.modelo.pojos.Aggregates stats;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String EQUIPO1 = "Equipo_local";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String EQUIPO2 = "Equipo_visitante";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String STATS = "Stats_equipos";
    @org.jetbrains.annotations.NotNull
    public static final com.example.footmatch.ui.EstadisticasFragment.Companion Companion = null;
    
    public EstadisticasFragment() {
        super();
    }
    
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/example/footmatch/ui/EstadisticasFragment$Companion;", "", "()V", "EQUIPO1", "", "EQUIPO2", "STATS", "newInstance", "Lcom/example/footmatch/ui/EstadisticasFragment;", "e1", "Lcom/example/footmatch/modelo/pojos/HomeTeamX;", "e2", "Lcom/example/footmatch/modelo/pojos/AwayTeamX;", "stats", "Lcom/example/footmatch/modelo/pojos/Aggregates;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.footmatch.ui.EstadisticasFragment newInstance(@org.jetbrains.annotations.NotNull
        com.example.footmatch.modelo.pojos.HomeTeamX e1, @org.jetbrains.annotations.NotNull
        com.example.footmatch.modelo.pojos.AwayTeamX e2, @org.jetbrains.annotations.Nullable
        com.example.footmatch.modelo.pojos.Aggregates stats) {
            return null;
        }
    }
}