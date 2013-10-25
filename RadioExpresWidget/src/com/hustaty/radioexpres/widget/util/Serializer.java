package com.hustaty.radioexpres.widget.util;

import com.hustaty.radioexpres.widget.model.Kml;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.transform.Matcher;
import org.simpleframework.xml.transform.Transform;

import java.io.*;

/**
 * User: slavino
 * Date: 10/24/13
 * Time: 7:17 PM
 */
public class Serializer {

    org.simpleframework.xml.Serializer serializer;

    /**
     * Instantiates a new serializer.
     */
    public Serializer() {
        serializer = new Persister(new KMLMatcher());
    }

    /**
     * This read method will read the contents of the XML document from the provided source and populate the object with the values deserialized.
     *
     * @param source the source
     * @return the kml
     * @throws Exception the exception
     */
    public Kml read(File source) throws Exception {
        return serializer.read(Kml.class, source, false);
    }

    /**
     * This read method will read the contents of the XML document from the provided source and populate the object with the values deserialized.
     *
     * @param source the source
     * @return the kml
     * @throws Exception the exception
     */
    public Kml read(InputNode source) throws Exception {
        return serializer.read(Kml.class, source, false);
    }

    /**
     * This read method will read the contents of the XML document from the provided source and populate the object with the values deserialized.
     *
     * @param source the source
     * @return the kml
     * @throws Exception the exception
     */
    public Kml read(InputStream source) throws Exception {
        return serializer.read(Kml.class, source, false);
    }

    /**
     * This read method will read the contents of the XML document from the provided source and populate the object with the values deserialized.
     *
     * @param source the source
     * @return the kml
     * @throws Exception the exception
     */
    public Kml read(Reader source) throws Exception {
        return serializer.read(Kml.class, source, false);
    }

    /**
     * This read method will read the contents of the XML document from the provided source and populate the object with the values deserialized.
     *
     * @param source the source
     * @return the kml
     * @throws Exception the exception
     */
    public Kml read(String source) throws Exception {
        return serializer.read(Kml.class, source, false);
    }

    /**
     * This write method will traverse the provided object checking for field annotations in order to compose the KML data.
     *
     * @param source the source
     * @param out the out
     * @return the file
     * @throws Exception the exception
     */
    public File write(Kml source, File out) throws Exception {
        serializer.write(source, out);
        return out;
    }

    /**
     * This write method will traverse the provided object checking for field annotations in order to compose the KML data.
     *
     * @param source the source
     * @param out the out
     * @return the output node
     * @throws Exception the exception
     */
    public OutputNode write(Kml source, OutputNode out) throws Exception {
        serializer.write(source, out);
        return out;
    }

    /**
     * This write method will traverse the provided object checking for field annotations in order to compose the KML data.
     *
     * @param source the source
     * @param out the out
     * @return the output stream
     * @throws Exception the exception
     */
    public OutputStream write(Kml source, OutputStream out) throws Exception {
        serializer.write(source, out);
        return out;
    }

    /**
     * This write method will traverse the provided object checking for field annotations in order to compose the KML data.
     *
     * @param source the source
     * @param out the out
     * @return the writer
     * @throws Exception the exception
     */
    public Writer write(Kml source, Writer out) throws Exception {
        serializer.write(source, out);
        return out;
    }

    /**
     * The Class KMLMatcher.
     */
    private class KMLMatcher implements Matcher {

        /* (non-Javadoc)
         * @see org.simpleframework.xml.transform.Matcher#match(java.lang.Class)
         */
        @SuppressWarnings("rawtypes")
        @Override
        public Transform<?> match(Class type) throws Exception {
//            if (type.equals(Coordinate.class))			return new CoordinateTransformer();
//            else if (type.equals(Coordinates.class))	return new CoordinatesTransformer();
            return null;
        }
//
//        /**
//         * The Class CoordinateTransformer.
//         */
//        public class CoordinateTransformer implements Transform<Coordinate> {
//
//            /* (non-Javadoc)
//             * @see org.simpleframework.xml.transform.Transform#read(java.lang.String)
//             */
//            @Override
//            public Coordinate read(String value) throws Exception {
//                return new Coordinate(value);
//            }
//
//            /* (non-Javadoc)
//             * @see org.simpleframework.xml.transform.Transform#write(java.lang.Object)
//             */
//            @Override
//            public String write(Coordinate value) throws Exception {
//                return value.toString();
//            }
//        }
//
//        /**
//         * The Class CoordinatesTransformer.
//         */
//        public class CoordinatesTransformer implements Transform<Coordinates> {
//
//            /* (non-Javadoc)
//             * @see org.simpleframework.xml.transform.Transform#read(java.lang.String)
//             */
//            @Override
//            public Coordinates read(String value) throws Exception {
//                return new Coordinates(value);
//            }
//
//            /* (non-Javadoc)
//             * @see org.simpleframework.xml.transform.Transform#write(java.lang.Object)
//             */
//            @Override
//            public String write(Coordinates value) throws Exception {
//                return value.toString();
//            }
//        }
    }

}
