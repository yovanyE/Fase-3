using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace ejemplobienHecho
{
    public partial class pageRegistroClientei : System.Web.UI.Page
    {
        wsBanco.BancoController control = new wsBanco.BancoController();

        protected void Page_Load(object sender, EventArgs e)
        {

        }
        public void limpiarCampos()
        {
            txtCui.Text = "";
            txtNombre.Text = "";
            txtApellido.Text = "";
            txtFechaNacimiento.Text = "";
            txtTelefono.Text = "";
            txtDireccion.Text = "";
            txtSueldo.Text = "";
            txtLogin.Text = "";
            txtPass.Text = "";
        }

        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
            try
            {
                if (control.registrarClienteindividual(int.Parse(txtCui.Text), txtNombre.Text, txtApellido.Text, txtFechaNacimiento.Text, txtTelefono.Text, txtDireccion.Text, int.Parse(txtSueldo.Text), txtPass.Text, txtLogin.Text) != null)
                {
                    lblMen.Text = "registro exitoso";
                    limpiarCampos();
                }
                else
                {
                    lblMen.Text = "Debe llenar todos los campos";
                }
            } catch
            {
                lblMen.Text = "campo no valido";
            }

        }

        protected void btnBuscar_Click(object sender, ImageClickEventArgs e)
        {
            try
            {
                wsBanco.clienteIndividual cliente = control.busquedaClienteindividual(int.Parse(txtBuscar.Text));

                if (control.busquedaClienteindividual(int.Parse(txtBuscar.Text)) != null)
                {
                    txtCui.Text = cliente.numeroCui.ToString();
                    txtNombre.Text = cliente.nombres;
                    txtApellido.Text = cliente.apellidos;
                    txtFechaNacimiento.Text = cliente.fechaNacimiento;
                    txtTelefono.Text = cliente.telefono;
                    txtDireccion.Text = cliente.direccion;
                    txtSueldo.Text = cliente.sueldo.ToString();
                    txtLogin.Text = cliente.login;
                    txtPass.Text = cliente.password;

                    lblMen.Text = "busqueda exitosa";
                }
                else
                {
                    lblMen.Text = "Cui del cliente no existe, debe registrarlo";
                }
            } catch
            {
                lblMen.Text = "Debe llenar el campo de busqueda";
            }

        }

        protected void btnElimina_Click(object sender, ImageClickEventArgs e)
        {
            try
            {
                if ((control.eliminarCliente(int.Parse(txtBuscar.Text))) != null)
                {
                    lblMen.Text = "DEBE LLENAR EL CAMPO DE BUSQUEDA";
                }
                else
                {
                    lblMen.Text = "REGISTRO ELIMINADO";
                    limpiarCampos();
                }
            }catch
            {
                lblMen.Text="DEBE LLENAR EL CAMPO DE BUSQUEDA";
            }
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            try
            {
                wsBanco.clienteIndividual modificar = control.modificarCindividual(int.Parse(txtCui.Text), txtNombre.Text, txtApellido.Text, txtFechaNacimiento.Text, txtTelefono.Text, txtDireccion.Text, Double.Parse(txtSueldo.Text), txtLogin.Text, txtPass.Text);
                if(control.modificarCindividual(int.Parse(txtCui.Text), txtNombre.Text, txtApellido.Text, txtFechaNacimiento.Text, txtTelefono.Text, txtDireccion.Text, Double.Parse(txtSueldo.Text), txtLogin.Text, txtPass.Text) != null)
                {
                    lblMen.Text = "Debe llenar todos los campos para modificar";
                }else
                {
                    limpiarCampos();
                    lblMen.Text = "modificacion exitosa";
                }
            }catch
            {
                lblMen.Text = "algun campo no esta lleno";
            }
        }
    }
}