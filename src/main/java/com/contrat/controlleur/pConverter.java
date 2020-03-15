package com.contrat.controlleur;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.contrat.dao.ConfProduitLocal;
import com.contrat.entities.Produit;

@FacesConverter(value = "produitConverter")
public class pConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext ctx, UIComponent uiComponent, String IdProduit) {
        ValueExpression vex =
                ctx.getApplication().getExpressionFactory()
                        .createValueExpression(ctx.getELContext(),
                                "#{ConfigurationProduit}", ConfigurationProduitControlleur.class);

        ConfProduitLocal produit = (ConfProduitLocal)vex.getValue(ctx.getELContext());
        return produit.rechercheProduit(Integer.valueOf(IdProduit));
    }

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		// TODO Auto-generated method stub
		return null;
	} 



}