package com.example.eliete.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CardExpansivel extends RelativeLayout implements View.OnClickListener {

    private TextView textoTituloCard;
    private TextView textoExpandir;
    private TextView icExpandir;
    private boolean aberturaCard;
    private ViewGroup[] arrayViewGroup;
    private String titulo;

    @Override
    public void onClick(View v) {
       if (isCardAberto()) {
            fecharCard();
        } else {
           expandirCard();
       }
    }

    public CardExpansivel(@NonNull Context context) {
        this(context, null);
    }

    public CardExpansivel(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CardExpansivel(Context context, @NonNull AttributeSet attrs, int
            defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inicializarAtributos(attrs);
        init();
    }

    private void inicializarAtributos(AttributeSet attrs) {
        TypedArray typedArray = getContext().getTheme()
                .obtainStyledAttributes(attrs, R.styleable.CardExpansivel, 0,0);
        titulo = typedArray.getString(R.styleable.CardExpansivel_titulo);
    }

    public void setViews(ViewGroup... rootViews) {
        arrayViewGroup = rootViews;
    }

    public void setTitulo(String titulo) {
        textoTituloCard.setText(titulo);
    }

    private void init() {
        View v = inflate(getContext(), R.layout.view_card_expansivel_cons,
                this);
        if (!isInEditMode()) {
            textoTituloCard = (TextView) v.findViewById(R.id.boleto_card);
            textoExpandir = (TextView) v.findViewById(R.id.expandir);
            icExpandir = (TextView) v.findViewById(R.id.ic_expandir);
            LinearLayout expandirContainer = (LinearLayout) v.findViewById(R.id
                    .expandir_container);
            expandirContainer.setOnClickListener(this);

            defineTextoBotaoCard("ocultar", "fecha aqui");
            setTitulo(titulo);
            aberturaCard = true;
        }
    }

    protected boolean isCardAberto() {
        return aberturaCard;
    }

    protected void expandirCard() {
        defineTextoBotaoCard("ocultar", "fecha aqui");
        aberturaCard = true;
        atribuiVisibilidadeDosViewgroups(VISIBLE);

    }

    private void defineTextoBotaoCard(String ocultar, String text) {
        textoExpandir.setText(ocultar);
        icExpandir.setText(text);
    }

    protected void fecharCard() {
        defineTextoBotaoCard("expandir", "abre aqui");
        aberturaCard = false;
        atribuiVisibilidadeDosViewgroups(GONE);
    }

    public void atribuiVisibilidadeDosViewgroups(int visibilidade) {
        for (ViewGroup viewgroup : arrayViewGroup) {
            viewgroup.setVisibility(visibilidade);
        }
    }
}
