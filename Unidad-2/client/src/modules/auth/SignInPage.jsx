import React, { useContext } from "react";
import { Button, Checkbox, Label, Spinner, TextInput } from "flowbite-react";
import { useFormik } from "formik";
import * as yup from "yup";
import customAlert from "../../config/alerts/alert";
import { useNavigate } from "react-router-dom";
import AxiosClient from "../../config/http-client/axios-client";
import AuthContext from "../../config/context/auth-context";

export const SignInPage = () => {
  const { user, dispatch } = useContext(AuthContext);
  const navigate = useNavigate();

  const formik = useFormik({
    initialValues: {
      username: "",
      password: "",
    },
    validationSchema: yup.object().shape({
      username: yup.string().required("Campo obligatorio*"),
      password: yup.string().required("Campo obligatorio*"),
    }),
    onSubmit: async (values, { setSubmitting }) => {
      console.log(values);
      try {
        const reponse = await AxiosClient({
          url: "/auth/signin",
          method: "POST",
          data: values,
        });
        if (!response.error) {
          /*
                Tienen que validar que el rol tiene
                -> Redireccionarlo a su página principal
            */
          dispatch({ type: "SIGNIN", payload: response.data });
          navigate("/admin", { replace: true });
        } else throw Error("Error");
      } catch (error) {
        customAlert(
          "Iniciar sesión",
          "Usuario y/o contraseña incorrectos",
          "info"
        );
      } finally {
        setSubmitting(false);
      }
    },
  });

  return (
    <>
      <div className="ripple-background">
        <div className="circle xxlarge shade1"></div>
        <div className="circle xlarge shade2"></div>
        <div className="circle large shade3"></div>
        <div className="circle mediun shade4"></div>
        <div className="circle small shade5"></div>
      </div>

      <form
        id="form"
        className="flex max-w-md flex-col gap-4"
        onSubmit={formik.handleSubmit}
        noValidate
      >
        <h1 id="title">INICIAR SESIÓN</h1>
        <div>
          <div className="mb-2 block">
            <Label htmlFor="email1" value="Correo Electrónico:" />
          </div>
          <TextInput
            id="email1"
            type="email"
            name="username"
            value={formik.values.username}
            onChange={formik.handleChange}
            onBlur={formik.handleBlur}
            helperText={
              formik.errors.username && formik.touched.username ? (
                <span className="text-red-600">{formik.errors.username}</span>
              ) : null
            }
            placeholder="Correo Electrónico"
            required
          />
        </div>
        <div>
          <div className="mb-2 block">
            <Label htmlFor="password1" value="Contraseña:" />
          </div>
          <TextInput
            id="password1"
            type="password"
            name="password"
            value={formik.values.password}
            onChange={formik.handleChange}
            onBlur={formik.handleBlur}
            helperText={
              formik.errors.password && formik.touched.password ? (
                <span className="text-red-600">{formik.errors.password}</span>
              ) : null
            }
            required
            placeholder="Contraseña"
          />
        </div>
        <div className="flex items-center gap-2">
          <Checkbox id="remember" />
          <Label htmlFor="remember">Recuérdame</Label>
        </div>
        <Button
          id="button"
          type="submit"
          gradientDuoTone="greenToBlue"
          disabled={formik.isSubmitting || !formik.isValid}
        >
          {formik.isSubmitting ? <Spinner /> : <>Iniciar Sesión</>}
        </Button>
      </form>
    </>
  );
};
