/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riobambarailway.controlador;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.flow.Flow;
import javax.faces.flow.builder.FlowBuilder;
import javax.faces.flow.builder.FlowBuilderParameter;
import javax.faces.flow.builder.FlowDefinition;
import javax.ws.rs.Produces;

/**
 *
 * @author Liseth
 */
@ManagedBean
@RequestScoped
public class FlowFactory implements Serializable{

    @Produces
    @FlowDefinition
    public Flow defineFlow(@FlowBuilderParameter FlowBuilder flowBuilder) {
        String flowId = "FlowCompra";
        flowBuilder.id("", flowId);
        flowBuilder.viewNode(flowId, "/pack1.xhtml").markAsStartNode();
         
        flowBuilder.returnNode("index")
                   .fromOutcome("#{PagoControlador.homeAction}");
         
        return flowBuilder.getFlow();
    }
    public FlowFactory() {
    }
    
    
    
}
