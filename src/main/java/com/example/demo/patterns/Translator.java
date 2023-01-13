package com.example.demo.patterns;

import com.example.demo.exceptions.BusinessException;

public interface Translator<I, O> {
  O translate(final I input) throws BusinessException;
}
