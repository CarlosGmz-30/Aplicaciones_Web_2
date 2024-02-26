import React, { useContext } from "react";
import {
  Route,
  RouterProvider,
  createBrowserRouter,
  createRoutesFromElements,
} from "react-router-dom";

import SignInPage from "../modules/auth/SignInPage";
import AuthContext from "../config/context/auth-context";
import AdminLayout from "../components/layout/AdminLayout";

const AppRouter = () => {
  const { user } = useContext(AuthContext);
  const router = createBrowserRouter(
    createRoutesFromElements(
      <>
        {user.signed ? (
          <>
            {" "}
            <Route path="/" element={<AdminLayout />}>
              <Route path="dashboard" element={<> Dashboard </>}></Route>
              <Route path="users" element={<> Usuarios </>}></Route>
              <Route path="products" element={<> Productos </>}></Route>
            </Route>{" "}
          </>
        ) : (
          <Route path="/" element={<SignInPage />} />
        )}
        <Route path="/*" element={<> 404 not found </>} />
      </>
    )
  );
  return <RouterProvider router={router} />;
};

export default AppRouter;
