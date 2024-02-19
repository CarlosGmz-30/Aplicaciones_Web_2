// Navegar entre componentes por medio de URL
import React, { useContext } from "react";
import { SignInPage } from "../modules/auth/SignInPage";
import AuthContext from "../config/context/auth-context";
import {
  Route,
  RouterProvider,
  createBrowserRouter,
  createRoutesFromElements,
} from "react-router-dom";
import AdminLayout from "../components/layout/AdminLayout";

const AppRouter = () => {
  const { user } = useContext(AuthContext);
  const router = createBrowserRouter(
    createRoutesFromElements(
      <>
        {
          user.signed ?
            <>
              <Route path="/" element={<AdminLayout />}>
                <Route path="dashboard" element={<>Dashboard</>} />
                <Route path="user" element={<>Dashboard</>} />
                <Route path="products" element={<>Dashboard</>} />
              </Route>
            </> :
            <Route path="/" element={<SignInPage />} />
        }
        <Route path="/" element={<>404 not found</>} />
      </>
    )
  );
  return <RouterProvider router={router} />;
};
export default AppRouter;
