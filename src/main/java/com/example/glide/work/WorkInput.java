package com.example.glide.work;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class WorkInput {

    private Map<String, Object> input;

    private ConfigurableConversionService configurableConversionService = new DefaultFormattingConversionService();

    public WorkInput(Map<String, Object> input) {
        this.input = input;
    }

    Map<String, Object> getInput() {
        return this.input;
    }


    public boolean getBoolean(String name) {
        return getBoolean(name, "true");
    }

    public boolean getBoolean(String name, String trueValue) {
        Assert.notNull(trueValue, "'trueValue' cannot be null.");
        String value = getInputString(name);
        return trueValue.equals(value);
    }

    public char getChar(String name) {
        String value = getInputString(name);
        if (value != null) {
            Assert.isTrue(value.length() == 1, "Cannot convert field value '" + value + "' to char.");
            return value.charAt(0);
        }
        return '\u0000';
    }

    public byte getByte(String name) {
        Byte b = convert(getInputString(name), Byte.class);
        return (b != null) ? b : 0;
    }

    public short getShort(String name) {
        Short s = convert(getInputString(name), Short.class);
        return (s != null) ? s : 0;
    }

    public int getInt(String name) {
        Integer i = convert(getInputString(name), Integer.class);
        return (i != null) ? i : 0;
    }

    public long getLong(String name) {
        Long l = convert(getInputString(name), Long.class);
        return (l != null) ? l : 0;
    }

    public float getFloat(String name) {
        Float f = convert(getInputString(name), Float.class);
        return (f != null) ? f : 0;
    }

    public double getDouble(String name) {
        Double d = convert(getInputString(name), Double.class);
        return (d != null) ? d : 0;
    }

    public BigDecimal getBigDecimal(String name) {
        return convert(getInputString(name), BigDecimal.class);
    }

    public Date getDate(String name) {
        return  convert(getInputString(name), Date.class);
    }

    public Date getDateWithPattern(String name, String pattern) {
        StringToDateConverter converter = new StringToDateConverter(pattern);
        return converter.convert(getInputString(name));
    }

    public <T> T getValue(String name, Class<T> valueClass) {
        return convert(getInputString(name), valueClass);
    }


    public String getInputString(String name) {
        Object rawValue = getInput().get(name);
        if (rawValue != null) {
            String value = convert(rawValue, String.class);
            if (value != null) {
                return value;
            }
            else {
                return null;
            }
        }
        else {
            return null;
        }
    }

    <T> T convert(Object value, Class<T> targetType) {
        return (T) configurableConversionService.convert(value, TypeDescriptor.forObject(value),
                TypeDescriptor.valueOf(targetType));
    }

    public class StringToDateConverter implements Converter<String, Date> {

        private final static String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";

        private DateFormat dateFormat;

        public StringToDateConverter() {
            this.dateFormat = new SimpleDateFormat(DEFAULT_DATE_PATTERN);
            this.dateFormat.setLenient(false);

        }

        public StringToDateConverter(String pattern) {
            this.dateFormat = new SimpleDateFormat(pattern);
            this.dateFormat.setLenient(false);
        }

        public StringToDateConverter(DateFormat dateFormat) {
            this.dateFormat = dateFormat;
        }

        @Override
        public Date convert(String source) {
            try {
                return dateFormat.parse(source);
            }
            catch (ParseException e) {
                String pattern;
                if (dateFormat instanceof SimpleDateFormat) {
                    pattern = ((SimpleDateFormat) dateFormat).toPattern();
                }
                else {
                    pattern = dateFormat.toString();
                }
                throw new IllegalArgumentException(e.getMessage() + ", format: [" + pattern + "]");
            }
        }

    }
}
