// Generated by view binder compiler. Do not edit!
package com.example.footmatch.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.footmatch.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityGoleadoresBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView atras;

  @NonNull
  public final LinearLayout equipo1Layout;

  @NonNull
  public final LinearLayout equipo2Layout;

  @NonNull
  public final LinearLayout equipo3Layout;

  @NonNull
  public final FrameLayout fragmentContainer;

  @NonNull
  public final ImageView headerImageView;

  @NonNull
  public final ImageView imageView11;

  @NonNull
  public final ImageView imageView21;

  @NonNull
  public final ImageView imageView31;

  @NonNull
  public final LinearLayout layout1;

  @NonNull
  public final RecyclerView recyclerViewPartidos1;

  @NonNull
  public final RecyclerView recyclerViewPartidos2;

  @NonNull
  public final RecyclerView recyclerViewPartidos3;

  @NonNull
  public final NestedScrollView scrollView;

  @NonNull
  public final TextView textView11;

  @NonNull
  public final TextView textView21;

  @NonNull
  public final TextView textView31;

  @NonNull
  public final TextView titleTextView;

  private ActivityGoleadoresBinding(@NonNull ConstraintLayout rootView, @NonNull ImageView atras,
      @NonNull LinearLayout equipo1Layout, @NonNull LinearLayout equipo2Layout,
      @NonNull LinearLayout equipo3Layout, @NonNull FrameLayout fragmentContainer,
      @NonNull ImageView headerImageView, @NonNull ImageView imageView11,
      @NonNull ImageView imageView21, @NonNull ImageView imageView31, @NonNull LinearLayout layout1,
      @NonNull RecyclerView recyclerViewPartidos1, @NonNull RecyclerView recyclerViewPartidos2,
      @NonNull RecyclerView recyclerViewPartidos3, @NonNull NestedScrollView scrollView,
      @NonNull TextView textView11, @NonNull TextView textView21, @NonNull TextView textView31,
      @NonNull TextView titleTextView) {
    this.rootView = rootView;
    this.atras = atras;
    this.equipo1Layout = equipo1Layout;
    this.equipo2Layout = equipo2Layout;
    this.equipo3Layout = equipo3Layout;
    this.fragmentContainer = fragmentContainer;
    this.headerImageView = headerImageView;
    this.imageView11 = imageView11;
    this.imageView21 = imageView21;
    this.imageView31 = imageView31;
    this.layout1 = layout1;
    this.recyclerViewPartidos1 = recyclerViewPartidos1;
    this.recyclerViewPartidos2 = recyclerViewPartidos2;
    this.recyclerViewPartidos3 = recyclerViewPartidos3;
    this.scrollView = scrollView;
    this.textView11 = textView11;
    this.textView21 = textView21;
    this.textView31 = textView31;
    this.titleTextView = titleTextView;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityGoleadoresBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityGoleadoresBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_goleadores, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityGoleadoresBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.atras;
      ImageView atras = ViewBindings.findChildViewById(rootView, id);
      if (atras == null) {
        break missingId;
      }

      id = R.id.equipo1Layout;
      LinearLayout equipo1Layout = ViewBindings.findChildViewById(rootView, id);
      if (equipo1Layout == null) {
        break missingId;
      }

      id = R.id.equipo2Layout;
      LinearLayout equipo2Layout = ViewBindings.findChildViewById(rootView, id);
      if (equipo2Layout == null) {
        break missingId;
      }

      id = R.id.equipo3Layout;
      LinearLayout equipo3Layout = ViewBindings.findChildViewById(rootView, id);
      if (equipo3Layout == null) {
        break missingId;
      }

      id = R.id.fragment_container;
      FrameLayout fragmentContainer = ViewBindings.findChildViewById(rootView, id);
      if (fragmentContainer == null) {
        break missingId;
      }

      id = R.id.headerImageView;
      ImageView headerImageView = ViewBindings.findChildViewById(rootView, id);
      if (headerImageView == null) {
        break missingId;
      }

      id = R.id.imageView1_1;
      ImageView imageView11 = ViewBindings.findChildViewById(rootView, id);
      if (imageView11 == null) {
        break missingId;
      }

      id = R.id.imageView2_1;
      ImageView imageView21 = ViewBindings.findChildViewById(rootView, id);
      if (imageView21 == null) {
        break missingId;
      }

      id = R.id.imageView3_1;
      ImageView imageView31 = ViewBindings.findChildViewById(rootView, id);
      if (imageView31 == null) {
        break missingId;
      }

      id = R.id.layout1;
      LinearLayout layout1 = ViewBindings.findChildViewById(rootView, id);
      if (layout1 == null) {
        break missingId;
      }

      id = R.id.recyclerViewPartidos1;
      RecyclerView recyclerViewPartidos1 = ViewBindings.findChildViewById(rootView, id);
      if (recyclerViewPartidos1 == null) {
        break missingId;
      }

      id = R.id.recyclerViewPartidos2;
      RecyclerView recyclerViewPartidos2 = ViewBindings.findChildViewById(rootView, id);
      if (recyclerViewPartidos2 == null) {
        break missingId;
      }

      id = R.id.recyclerViewPartidos3;
      RecyclerView recyclerViewPartidos3 = ViewBindings.findChildViewById(rootView, id);
      if (recyclerViewPartidos3 == null) {
        break missingId;
      }

      id = R.id.scrollView;
      NestedScrollView scrollView = ViewBindings.findChildViewById(rootView, id);
      if (scrollView == null) {
        break missingId;
      }

      id = R.id.textView1_1;
      TextView textView11 = ViewBindings.findChildViewById(rootView, id);
      if (textView11 == null) {
        break missingId;
      }

      id = R.id.textView2_1;
      TextView textView21 = ViewBindings.findChildViewById(rootView, id);
      if (textView21 == null) {
        break missingId;
      }

      id = R.id.textView3_1;
      TextView textView31 = ViewBindings.findChildViewById(rootView, id);
      if (textView31 == null) {
        break missingId;
      }

      id = R.id.titleTextView;
      TextView titleTextView = ViewBindings.findChildViewById(rootView, id);
      if (titleTextView == null) {
        break missingId;
      }

      return new ActivityGoleadoresBinding((ConstraintLayout) rootView, atras, equipo1Layout,
          equipo2Layout, equipo3Layout, fragmentContainer, headerImageView, imageView11,
          imageView21, imageView31, layout1, recyclerViewPartidos1, recyclerViewPartidos2,
          recyclerViewPartidos3, scrollView, textView11, textView21, textView31, titleTextView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
