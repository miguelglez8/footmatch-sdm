// Generated by view binder compiler. Do not edit!
package com.example.footmatch.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
  private final LinearLayout rootView;

  @NonNull
  public final TextView equipoLiga;

  @NonNull
  public final ImageView imagenEquipo;

  @NonNull
  public final TextView puntosEquipo;

  private LinearClasificationEquipoBinding(@NonNull LinearLayout rootView,
      @NonNull TextView equipoLiga, @NonNull ImageView imagenEquipo,
      @NonNull TextView puntosEquipo) {
    this.rootView = rootView;
    this.equipoLiga = equipoLiga;
    this.imagenEquipo = imagenEquipo;
    this.puntosEquipo = puntosEquipo;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
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
      id = R.id.equipoLiga;
      TextView equipoLiga = ViewBindings.findChildViewById(rootView, id);
      if (equipoLiga == null) {
        break missingId;
      }

      id = R.id.imagenEquipo;
      ImageView imagenEquipo = ViewBindings.findChildViewById(rootView, id);
      if (imagenEquipo == null) {
        break missingId;
      }

      id = R.id.puntosEquipo;
      TextView puntosEquipo = ViewBindings.findChildViewById(rootView, id);
      if (puntosEquipo == null) {
        break missingId;
      }

      return new LinearClasificationEquipoBinding((LinearLayout) rootView, equipoLiga, imagenEquipo,
          puntosEquipo);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}