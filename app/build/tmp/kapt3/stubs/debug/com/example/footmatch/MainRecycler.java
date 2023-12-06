package com.example.footmatch;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000  2\u00020\u0001:\u0001 B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0018\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0017H\u0002J\u0012\u0010\u001d\u001a\u00020\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006!"}, d2 = {"Lcom/example/footmatch/MainRecycler;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "listaPartidosAdapter", "Lcom/example/footmatch/ListaPartidosAdapter;", "listaPartidosView", "Landroidx/recyclerview/widget/RecyclerView;", "getListaPartidosView", "()Landroidx/recyclerview/widget/RecyclerView;", "setListaPartidosView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mOnNavigationItemSelectedListener", "Lcom/google/android/material/bottomnavigation/BottomNavigationView$OnNavigationItemSelectedListener;", "matchList", "", "Lcom/example/footmatch/modelo/pojos/Match;", "getMatchList", "()Ljava/util/List;", "setMatchList", "(Ljava/util/List;)V", "cargarClasificacion", "", "liga", "", "cargarEquiposParaClasificacion", "Lcom/example/footmatch/modelo/Equipo;", "cargarPartidos", "dateFrom", "dateTo", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_debug"})
public final class MainRecycler extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.example.footmatch.modelo.pojos.Match> matchList;
    @org.jetbrains.annotations.Nullable
    private androidx.recyclerview.widget.RecyclerView listaPartidosView;
    private com.example.footmatch.ListaPartidosAdapter listaPartidosAdapter;
    @org.jetbrains.annotations.NotNull
    private final com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = null;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String PARTIDO_SELECCIONADO = "partido_seleccionado";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String LIGA_CREADA = "liga_creada";
    @org.jetbrains.annotations.NotNull
    public static final com.example.footmatch.MainRecycler.Companion Companion = null;
    
    public MainRecycler() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.example.footmatch.modelo.pojos.Match> getMatchList() {
        return null;
    }
    
    public final void setMatchList(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.footmatch.modelo.pojos.Match> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final androidx.recyclerview.widget.RecyclerView getListaPartidosView() {
        return null;
    }
    
    public final void setListaPartidosView(@org.jetbrains.annotations.Nullable
    androidx.recyclerview.widget.RecyclerView p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void cargarPartidos(java.lang.String dateFrom, java.lang.String dateTo) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.example.footmatch.modelo.Equipo> cargarEquiposParaClasificacion(@org.jetbrains.annotations.Nullable
    java.lang.String liga) {
        return null;
    }
    
    public final void cargarClasificacion(@org.jetbrains.annotations.Nullable
    java.lang.String liga) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/example/footmatch/MainRecycler$Companion;", "", "()V", "LIGA_CREADA", "", "PARTIDO_SELECCIONADO", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}