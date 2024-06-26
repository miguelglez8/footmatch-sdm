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

public final class ItemArbitrosBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView tvArbitroName;

  @NonNull
  public final TextView tvFunction;

  private ItemArbitrosBinding(@NonNull LinearLayout rootView, @NonNull TextView tvArbitroName,
      @NonNull TextView tvFunction) {
    this.rootView = rootView;
    this.tvArbitroName = tvArbitroName;
    this.tvFunction = tvFunction;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemArbitrosBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemArbitrosBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_arbitros, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemArbitrosBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.tvArbitroName;
      TextView tvArbitroName = ViewBindings.findChildViewById(rootView, id);
      if (tvArbitroName == null) {
        break missingId;
      }

      id = R.id.tvFunction;
      TextView tvFunction = ViewBindings.findChildViewById(rootView, id);
      if (tvFunction == null) {
        break missingId;
      }

      return new ItemArbitrosBinding((LinearLayout) rootView, tvArbitroName, tvFunction);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
