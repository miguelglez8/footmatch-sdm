// Generated by view binder compiler. Do not edit!
package com.example.footmatch.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public final class ItemJugadorBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView textDorsal;

  @NonNull
  public final TextView textNombreJugador;

  @NonNull
  public final TextView textPosicion;

  private ItemJugadorBinding(@NonNull LinearLayout rootView, @NonNull TextView textDorsal,
      @NonNull TextView textNombreJugador, @NonNull TextView textPosicion) {
    this.rootView = rootView;
    this.textDorsal = textDorsal;
    this.textNombreJugador = textNombreJugador;
    this.textPosicion = textPosicion;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemJugadorBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemJugadorBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_jugador, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemJugadorBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.textDorsal;
      TextView textDorsal = ViewBindings.findChildViewById(rootView, id);
      if (textDorsal == null) {
        break missingId;
      }

      id = R.id.textNombreJugador;
      TextView textNombreJugador = ViewBindings.findChildViewById(rootView, id);
      if (textNombreJugador == null) {
        break missingId;
      }

      id = R.id.textPosicion;
      TextView textPosicion = ViewBindings.findChildViewById(rootView, id);
      if (textPosicion == null) {
        break missingId;
      }

      return new ItemJugadorBinding((LinearLayout) rootView, textDorsal, textNombreJugador,
          textPosicion);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
