package com.example.footmatch;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0014\u0015\u0016B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\nH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/example/footmatch/ListaEventosAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/footmatch/ListaEventosAdapter$EventoViewHolder;", "listaEventos", "", "Lcom/example/footmatch/modelo/eventos/Evento;", "listener", "Lcom/example/footmatch/ListaEventosAdapter$OnItemClickListener;", "(Ljava/util/List;Lcom/example/footmatch/ListaEventosAdapter$OnItemClickListener;)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "EventoViewHolder", "OnItemClickListener", "app_debug"})
public final class ListaEventosAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.footmatch.ListaEventosAdapter.EventoViewHolder> {
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.example.footmatch.modelo.eventos.Evento> listaEventos = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.footmatch.ListaEventosAdapter.OnItemClickListener listener = null;
    private static final int TIPO_LOCAL = 0;
    private static final int TIPO_VISITANTE = 1;
    @org.jetbrains.annotations.NotNull
    public static final com.example.footmatch.ListaEventosAdapter.Companion Companion = null;
    
    public ListaEventosAdapter(@org.jetbrains.annotations.NotNull
    java.util.List<? extends com.example.footmatch.modelo.eventos.Evento> listaEventos, @org.jetbrains.annotations.NotNull
    com.example.footmatch.ListaEventosAdapter.OnItemClickListener listener) {
        super();
    }
    
    @java.lang.Override
    public int getItemViewType(int position) {
        return 0;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.example.footmatch.ListaEventosAdapter.EventoViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    /**
     * Asocia el contenido a los componentes de la vista,
     * concretamente con nuestro EventoViewHolder que recibimos como parámetro
     */
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.example.footmatch.ListaEventosAdapter.EventoViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/example/footmatch/ListaEventosAdapter$Companion;", "", "()V", "TIPO_LOCAL", "", "TIPO_VISITANTE", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/example/footmatch/ListaEventosAdapter$EventoViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "icono1", "Landroid/widget/ImageView;", "icono2", "minutoEvento", "Landroid/widget/TextView;", "primerFactor", "segundoFactor", "bindEvento", "", "evento", "Lcom/example/footmatch/modelo/eventos/Evento;", "listener", "Lcom/example/footmatch/ListaEventosAdapter$OnItemClickListener;", "app_debug"})
    public static final class EventoViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView primerFactor = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView segundoFactor = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.ImageView icono1 = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.ImageView icono2 = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView minutoEvento = null;
        
        public EventoViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View itemView) {
            super(null);
        }
        
        public final void bindEvento(@org.jetbrains.annotations.NotNull
        com.example.footmatch.modelo.eventos.Evento evento, @org.jetbrains.annotations.NotNull
        com.example.footmatch.ListaEventosAdapter.OnItemClickListener listener) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/footmatch/ListaEventosAdapter$OnItemClickListener;", "", "onItemClick", "", "item", "Lcom/example/footmatch/modelo/eventos/Evento;", "app_debug"})
    public static abstract interface OnItemClickListener {
        
        public abstract void onItemClick(@org.jetbrains.annotations.Nullable
        com.example.footmatch.modelo.eventos.Evento item);
    }
}