package com.mg.restData

import org.springframework.beans.factory.annotation.Qualifier
import javax.annotation.security.RolesAllowed

@Qualifier
@Target(AnnotationTarget.TYPE)
annotation class MyAnnotation