package com.example.footmatch.ui;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 #2\u00020\u0001:\u0001#B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010 \u001a\u00020\u00172\b\u0010!\u001a\u0004\u0018\u00010\u00112\u0006\u0010\"\u001a\u00020\u0004H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/example/footmatch/ui/EventosFragment;", "Landroidx/fragment/app/Fragment;", "()V", "adapterCambios", "Lcom/example/footmatch/ListaEventosAdapter;", "adapterGoles", "adapterTarjetas", "bookings", "", "Lcom/example/footmatch/modelo/pojos/Booking;", "goals", "Lcom/example/footmatch/modelo/pojos/Goal;", "local", "", "penalties", "Lcom/example/footmatch/modelo/pojos/Penalty;", "recyclerViewCambios", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerViewGoles", "recyclerViewTarjetas", "substitutions", "Lcom/example/footmatch/modelo/pojos/Substitution;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "setUpRecyclerView", "recyclerView", "adapter", "Companion", "app_debug"})
public final class EventosFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable
    private java.util.List<com.example.footmatch.modelo.pojos.Goal> goals;
    @org.jetbrains.annotations.Nullable
    private java.util.List<com.example.footmatch.modelo.pojos.Penalty> penalties;
    @org.jetbrains.annotations.Nullable
    private java.util.List<com.example.footmatch.modelo.pojos.Booking> bookings;
    @org.jetbrains.annotations.Nullable
    private java.util.List<com.example.footmatch.modelo.pojos.Substitution> substitutions;
    @org.jetbrains.annotations.Nullable
    private java.lang.String local;
    @org.jetbrains.annotations.Nullable
    private androidx.recyclerview.widget.RecyclerView recyclerViewGoles;
    @org.jetbrains.annotations.Nullable
    private androidx.recyclerview.widget.RecyclerView recyclerViewTarjetas;
    @org.jetbrains.annotations.Nullable
    private androidx.recyclerview.widget.RecyclerView recyclerViewCambios;
    @org.jetbrains.annotations.Nullable
    private com.example.footmatch.ListaEventosAdapter adapterGoles;
    @org.jetbrains.annotations.Nullable
    private com.example.footmatch.ListaEventosAdapter adapterTarjetas;
    @org.jetbrains.annotations.Nullable
    private com.example.footmatch.ListaEventosAdapter adapterCambios;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String GOALS = "GOALS";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String PENALTIES = "PENALTIES";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String BOOKINGS = "BOOKINGS";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String SUBSTITUTIONS = "SUBSTITUTIONS";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String LOCAL = "LOCAL";
    @org.jetbrains.annotations.NotNull
    public static final com.example.footmatch.ui.EventosFragment.Companion Companion = null;
    
    public EventosFragment() {
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
    
    private final void setUpRecyclerView(androidx.recyclerview.widget.RecyclerView recyclerView, com.example.footmatch.ListaEventosAdapter adapter) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002JF\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\f2\u0006\u0010\u0014\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/example/footmatch/ui/EventosFragment$Companion;", "", "()V", "BOOKINGS", "", "GOALS", "LOCAL", "PENALTIES", "SUBSTITUTIONS", "newInstance", "Lcom/example/footmatch/ui/EventosFragment;", "goals", "", "Lcom/example/footmatch/modelo/pojos/Goal;", "penalties", "Lcom/example/footmatch/modelo/pojos/Penalty;", "bookings", "Lcom/example/footmatch/modelo/pojos/Booking;", "substitutions", "Lcom/example/footmatch/modelo/pojos/Substitution;", "localTeam", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.footmatch.ui.EventosFragment newInstance(@org.jetbrains.annotations.NotNull
        java.util.List<com.example.footmatch.modelo.pojos.Goal> goals, @org.jetbrains.annotations.NotNull
        java.util.List<com.example.footmatch.modelo.pojos.Penalty> penalties, @org.jetbrains.annotations.NotNull
        java.util.List<com.example.footmatch.modelo.pojos.Booking> bookings, @org.jetbrains.annotations.NotNull
        java.util.List<com.example.footmatch.modelo.pojos.Substitution> substitutions, @org.jetbrains.annotations.NotNull
        java.lang.String localTeam) {
            return null;
        }
    }
}