package com.example.footmatch;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0015\u0016B)\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\u0016\u0010\u0013\u001a\u00020\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/example/footmatch/ListaPartidosAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/footmatch/ListaPartidosAdapter$PartidoViewHolder;", "matchList", "", "Lcom/example/footmatch/modelo/pojos/Match;", "onItemSelected", "Lkotlin/Function1;", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "update", "listaPartidos", "Companion", "PartidoViewHolder", "app_debug"})
public final class ListaPartidosAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.footmatch.ListaPartidosAdapter.PartidoViewHolder> {
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.example.footmatch.modelo.pojos.Match> matchList;
    @org.jetbrains.annotations.NotNull
    private final kotlin.jvm.functions.Function1<com.example.footmatch.modelo.pojos.Match, kotlin.Unit> onItemSelected = null;
    @org.jetbrains.annotations.NotNull
    public static final com.example.footmatch.ListaPartidosAdapter.Companion Companion = null;
    
    public ListaPartidosAdapter(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.footmatch.modelo.pojos.Match> matchList, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.example.footmatch.modelo.pojos.Match, kotlin.Unit> onItemSelected) {
        super();
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void update(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.footmatch.modelo.pojos.Match> listaPartidos) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.example.footmatch.ListaPartidosAdapter.PartidoViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    /**
     * Asocia el contenido a los componentes de la vista,
     * concretamente con nuestro PartidoViewHolder que recibimos como parámetro
     */
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.example.footmatch.ListaPartidosAdapter.PartidoViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002\u00a8\u0006\u0006"}, d2 = {"Lcom/example/footmatch/ListaPartidosAdapter$Companion;", "", "()V", "formatDate", "", "utcDate", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        private final java.lang.String formatDate(java.lang.String utcDate) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000f0\u0013J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/example/footmatch/ListaPartidosAdapter$PartidoViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "fecha", "Landroid/widget/TextView;", "logoLocal", "Landroid/widget/ImageView;", "logoVisitante", "nombreLocal", "nombreVisitante", "resultadoLocal", "resultadoVisitante", "bindUser", "", "match", "Lcom/example/footmatch/modelo/pojos/Match;", "listener", "Lkotlin/Function1;", "mostrarPartido", "app_debug"})
    public static final class PartidoViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final android.widget.ImageView logoLocal = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView nombreLocal = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.ImageView logoVisitante = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView nombreVisitante = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView resultadoLocal = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView resultadoVisitante = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView fecha = null;
        
        public PartidoViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View itemView) {
            super(null);
        }
        
        public final void bindUser(@org.jetbrains.annotations.NotNull
        com.example.footmatch.modelo.pojos.Match match, @org.jetbrains.annotations.NotNull
        kotlin.jvm.functions.Function1<? super com.example.footmatch.modelo.pojos.Match, kotlin.Unit> listener) {
        }
        
        private final void mostrarPartido(com.example.footmatch.modelo.pojos.Match match) {
        }
    }
}