// Generated by view binder compiler. Do not edit!
package com.example.footmatch.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.footmatch.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class LinearClasificationEquipoBinding implements ViewBinding {
  @NonNull
  private final TableLayout rootView;

  @NonNull
  public final TextView diferenciaGoles;

  @NonNull
  public final TextView golesContra;

  @NonNull
  public final TextView golesFavor;

  @NonNull
  public final ImageView logoEquipo;

  @NonNull
  public final TextView partidosEmpatados;

  @NonNull
  public final TextView partidosGanados;

  @NonNull
  public final TextView partidosPerdidos;

  @NonNull
  public final TextView posClasificacion;

  @NonNull
  public final TextView puntosEquipo;

  @NonNull
  public final TableLayout tableLayout;

  @NonNull
  public final TableRow tuTableRow;

  private LinearClasificationEquipoBinding(@NonNull TableLayout rootView,
      @NonNull TextView diferenciaGoles, @NonNull TextView golesContra,
      @NonNull TextView golesFavor, @NonNull ImageView logoEquipo,
      @NonNull TextView partidosEmpatados, @NonNull TextView partidosGanados,
      @NonNull TextView partidosPerdidos, @NonNull TextView posClasificacion,
      @NonNull TextView puntosEquipo, @NonNull TableLayout tableLayout,
      @NonNull TableRow tuTableRow) {
    this.rootView = rootView;
    this.diferenciaGoles = diferenciaGoles;
    this.golesContra = golesContra;
    this.golesFavor = golesFavor;
    this.logoEquipo = logoEquipo;
    this.partidosEmpatados = partidosEmpatados;
    this.partidosGanados = partidosGanados;
    this.partidosPerdidos = partidosPerdidos;
    this.posClasificacion = posClasificacion;
    this.puntosEquipo = puntosEquipo;
    this.tableLayout = tableLayout;
    this.tuTableRow = tuTableRow;
  }

  @Override
  @NonNull
  public TableLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static LinearClasificationEquipoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LinearClasificationEquipoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.linear_clasification_equipo, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LinearClasificationEquipoBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.diferenciaGoles;
      TextView diferenciaGoles = ViewBindings.findChildViewById(rootView, id);
      if (diferenciaGoles == null) {
        break missingId;
      }

      id = R.id.golesContra;
      TextView golesContra = ViewBindings.findChildViewById(rootView, id);
      if (golesContra == null) {
        break missingId;
      }

      id = R.id.golesFavor;
      TextView golesFavor = ViewBindings.findChildViewById(rootView, id);
      if (golesFavor == null) {
        break missingId;
      }

      id = R.id.logoEquipo;
      ImageView logoEquipo = ViewBindings.findChildViewById(rootView, id);
      if (logoEquipo == null) {
        break missingId;
      }

      id = R.id.partidosEmpatados;
      TextView partidosEmpatados = ViewBindings.findChildViewById(rootView, id);
      if (partidosEmpatados == null) {
        break missingId;
      }

      id = R.id.partidosGanados;
      TextView partidosGanados = ViewBindings.findChildViewById(rootView, id);
      if (partidosGanados == null) {
        break missingId;
      }

      id = R.id.partidosPerdidos;
      TextView partidosPerdidos = ViewBindings.findChildViewById(rootView, id);
      if (partidosPerdidos == null) {
        break missingId;
      }

      id = R.id.posClasificacion;
      TextView posClasificacion = ViewBindings.findChildViewById(rootView, id);
      if (posClasificacion == null) {
        break missingId;
      }

      id = R.id.puntosEquipo;
      TextView puntosEquipo = ViewBindings.findChildViewById(rootView, id);
      if (puntosEquipo == null) {
        break missingId;
      }

      id = R.id.tableLayout;
      TableLayout tableLayout = ViewBindings.findChildViewById(rootView, id);
      if (tableLayout == null) {
        break missingId;
      }

      id = R.id.tuTableRow;
      TableRow tuTableRow = ViewBindings.findChildViewById(rootView, id);
      if (tuTableRow == null) {
        break missingId;
      }

      return new LinearClasificationEquipoBinding((TableLayout) rootView, diferenciaGoles,
          golesContra, golesFavor, logoEquipo, partidosEmpatados, partidosGanados, partidosPerdidos,
          posClasificacion, puntosEquipo, tableLayout, tuTableRow);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
