using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace ejemplobienHecho
{
    public partial class pagePrestamo : System.Web.UI.Page
    {
        wsBanco.BancoController control = new wsBanco.BancoController();
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        public void limpiarCampos()
        {
            txtCantidad.Text = "";
            txtCui.Text = "";
            ddlModalidad.ClearSelection();
        }
        protected void btnBuscar_Click(object sender, ImageClickEventArgs e)
        {
            try
            {
                wsBanco.prestamo prestar = control.buscarPrestamos(int.Parse(txtBuscar.Text));
                if (control.buscarPrestamos(int.Parse(txtBuscar.Text)) != null)
                {
                    txtCantidad.Text = prestar.cantidadDinero.ToString();
                    txtCui.Text = prestar.numeroCui.ToString();
                    ddlModalidad.SelectedIndex = ddlModalidad.Items.IndexOf(ddlModalidad.Items.FindByValue(prestar.modalidad.ToString()));
                    txtFecha.Text = prestar.fecha;
                }else
                {
                    lblMen.Text = "Cui del cliente no existe, debe registrarlo";
                }
            }catch
            {
                lblMen.Text = "Debe llenar el campo de busqueda";
            }
        }

        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
            try
            {
                if (control.registrarPrestamo(int.Parse(txtCantidad.Text), int.Parse(txtCui.Text), int.Parse(ddlModalidad.SelectedValue.ToString()),txtFecha.Text) != null)
                {
                    limpiarCampos();
                    lblMen.Text = "Presatmo registrado exitosamente";
                }
                else
                {
                    lblMen.Text = "Debe llenar todos los campos";
                }
            }catch
            {
                lblMen.Text = "tipo de dato incorrecto ingresado";
            }
        }

        protected void btnElimina_Click(object sender, ImageClickEventArgs e)
        {
            if(control.eliminarPrestamo(int.Parse(txtBuscar.Text))!=null){
                lblMen.Text = "No esta eliminando ningun registro";
            }else
            {
                limpiarCampos();
                lblMen.Text = "Registsro eliminado";
            }
        }

        protected void btnCancelar_Click(object sender, EventArgs e)
        {
            limpiarCampos();
        }

        protected void btnNuevo_Click(object sender, EventArgs e)
        {
            ListItem tipo1 = new ListItem("Quincenal", "1");
            ddlModalidad.Items.Add(tipo1);
            ListItem tipo2 = new ListItem("Mensual", "2");
            ddlModalidad.Items.Add(tipo2);
            ListItem tipo3 = new ListItem("Trimestral", "3");
            ddlModalidad.Items.Add(tipo3);
        }

        protected void btnReporte_Click(object sender, ImageClickEventArgs e)
        {
            control.reportePrestamo();
        }
    }
}