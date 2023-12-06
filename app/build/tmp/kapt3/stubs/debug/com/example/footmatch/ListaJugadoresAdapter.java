package com.example.footmatch;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0013\u0014B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/example/footmatch/ListaJugadoresAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/footmatch/ListaJugadoresAdapter$JugadorViewHolder;", "listaJugadores", "", "Lcom/example/footmatch/modelo/pojos/Lineup;", "listener", "Lcom/example/footmatch/ListaJugadoresAdapter$OnItemClickListener;", "(Ljava/util/List;Lcom/example/footmatch/ListaJugadoresAdapter$OnItemClickListener;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "JugadorViewHolder", "OnItemClickListener", "app_debug"})
public final class ListaJugadoresAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.footmatch.ListaJugadoresAdapter.JugadorViewHolder> {
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.example.footmatch.modelo.pojos.Lineup> listaJugadores = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.footmatch.ListaJugadoresAdapter.OnItemClickListener listener = null;
    
    public ListaJugadoresAdapter(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.footmatch.modelo.pojos.Lineup> listaJugadores, @org.jetbrains.annotations.NotNull
    com.example.footmatch.ListaJugadoresAdapter.OnItemClickListener listener) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.example.footmatch.ListaJugadoresAdapter.JugadorViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    /**
     * Asocia el contenido a los componentes de la vista,
     * concretamente con nuestro PartidoViewHolder que recibimos como parámetro
     */
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.example.footmatch.ListaJugadoresAdapter.JugadorViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/example/footmatch/ListaJugadoresAdapter$JugadorViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "dorsal", "Landroid/widget/TextView;", "jugador", "posicion", "bindUser", "", "Lcom/example/footmatch/modelo/pojos/Lineup;", "listener", "Lcom/example/footmatch/ListaJugadoresAdapter$OnItemClickListener;", "app_debug"})
    public static final class JugadorViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView dorsal = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView jugador = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView posicion = null;
        
        public JugadorViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View itemView) {
            super(null);
        }
        
        public final void bindUser(@org.jetbrains.annotations.NotNull
        com.example.footmatch.modelo.pojos.Lineup jugador, @org.jetbrains.annotations.Nullable
        com.example.footmatch.ListaJugadoresAdapter.OnItemClickListener listener) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/footmatch/ListaJugadoresAdapter$OnItemClickListener;", "", "onItemClick", "", "item", "Lcom/example/footmatch/modelo/pojos/Lineup;", "app_debug"})
    public static abstract interface OnItemClickListener {
        
        public abstract void onItemClick(@org.jetbrains.annotations.Nullable
        com.example.footmatch.modelo.pojos.Lineup item);
    }
}