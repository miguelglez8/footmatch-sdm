package com.example.footmatch.ui;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 %2\u00020\u0001:\u0001%B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u0012\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J&\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0017J\u001a\u0010\"\u001a\u00020\u00182\b\u0010#\u001a\u0004\u0018\u00010\u00152\u0006\u0010$\u001a\u00020\u0004H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/example/footmatch/ui/AlineacionesFragment;", "Landroidx/fragment/app/Fragment;", "()V", "adapterEquipo1", "Lcom/example/footmatch/ListaJugadoresAdapter;", "adapterEquipo2", "entrenadorEquipo1", "Landroid/widget/TextView;", "entrenadorEquipo2", "formacionEquipo1", "formacionEquipo2", "imagenEquipo1", "Landroid/widget/ImageView;", "imagenEquipo2", "jugadoresEquipo1", "Lcom/example/footmatch/modelo/pojos/HomeTeamX;", "jugadoresEquipo2", "Lcom/example/footmatch/modelo/pojos/AwayTeamX;", "nombreEquipo1", "nombreEquipo2", "recyclerViewJugadoresEquipo1", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerViewJugadoresEquipo2", "cargarDatos", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "setUpRecyclerView", "recyclerView", "adapter", "Companion", "app_debug"})
public final class AlineacionesFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable
    private com.example.footmatch.modelo.pojos.HomeTeamX jugadoresEquipo1;
    @org.jetbrains.annotations.Nullable
    private com.example.footmatch.modelo.pojos.AwayTeamX jugadoresEquipo2;
    @org.jetbrains.annotations.Nullable
    private androidx.recyclerview.widget.RecyclerView recyclerViewJugadoresEquipo1;
    @org.jetbrains.annotations.Nullable
    private androidx.recyclerview.widget.RecyclerView recyclerViewJugadoresEquipo2;
    @org.jetbrains.annotations.Nullable
    private android.widget.TextView nombreEquipo1;
    @org.jetbrains.annotations.Nullable
    private android.widget.TextView nombreEquipo2;
    @org.jetbrains.annotations.Nullable
    private android.widget.TextView entrenadorEquipo1;
    @org.jetbrains.annotations.Nullable
    private android.widget.TextView entrenadorEquipo2;
    @org.jetbrains.annotations.Nullable
    private android.widget.TextView formacionEquipo1;
    @org.jetbrains.annotations.Nullable
    private android.widget.TextView formacionEquipo2;
    @org.jetbrains.annotations.Nullable
    private android.widget.ImageView imagenEquipo1;
    @org.jetbrains.annotations.Nullable
    private android.widget.ImageView imagenEquipo2;
    @org.jetbrains.annotations.Nullable
    private com.example.footmatch.ListaJugadoresAdapter adapterEquipo1;
    @org.jetbrains.annotations.Nullable
    private com.example.footmatch.ListaJugadoresAdapter adapterEquipo2;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String JUGADORES_EQUIPO1 = "Equipo1";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String JUGADORES_EQUIPO2 = "Equipo2";
    @org.jetbrains.annotations.NotNull
    public static final com.example.footmatch.ui.AlineacionesFragment.Companion Companion = null;
    
    public AlineacionesFragment() {
        super();
    }
    
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    @android.annotation.SuppressLint(value = {"MissingInflatedId"})
    @org.jetbrains.annotations.Nullable
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void setUpRecyclerView(androidx.recyclerview.widget.RecyclerView recyclerView, com.example.footmatch.ListaJugadoresAdapter adapter) {
    }
    
    private final void cargarDatos() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/example/footmatch/ui/AlineacionesFragment$Companion;", "", "()V", "JUGADORES_EQUIPO1", "", "JUGADORES_EQUIPO2", "newInstance", "Lcom/example/footmatch/ui/AlineacionesFragment;", "e1", "Lcom/example/footmatch/modelo/pojos/HomeTeamX;", "e2", "Lcom/example/footmatch/modelo/pojos/AwayTeamX;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.footmatch.ui.AlineacionesFragment newInstance(@org.jetbrains.annotations.NotNull
        com.example.footmatch.modelo.pojos.HomeTeamX e1, @org.jetbrains.annotations.NotNull
        com.example.footmatch.modelo.pojos.AwayTeamX e2) {
            return null;
        }
    }
}