package com.tj.spensa.Presentations;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.airbnb.lottie.LottieAnimationView;
import com.tj.spensa.R;

public class ViewPresentationAdapter extends PagerAdapter {

    Context context;

    int sliderAnimaciones[] = {
            R.raw.animacion_bienvenida,
            R.raw.animacion_flujo,
            R.raw.animacion_seguridad
    };

    int sliderTitulos [] = {
            R.string.cabecero_uno,
            R.string.cabecero_dos,
            R.string.cabecero_tres
    };

    int sliderDescripcion [] = {
            R.string.descripcion_uno,
            R.string.descripcion_dos,
            R.string.descripcion_tres
    };

    public ViewPresentationAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return sliderTitulos.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position){

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider_layout, container, false);

        LottieAnimationView sliderImage = (LottieAnimationView) view.findViewById(R.id.animacionSlider);
        TextView sliderTitle = (TextView) view.findViewById(R.id.titleSlider);
        TextView sliderDescription = (TextView) view.findViewById(R.id.descriptionSlider);

        sliderImage.setAnimation(sliderAnimaciones[position]);
        sliderTitle.setText(sliderTitulos[position]);
        sliderDescription.setText(sliderDescripcion[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object){
        container.removeView((LinearLayout)object);
    }
}
